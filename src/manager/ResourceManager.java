package manager;

import config.Config;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {

    private static ResourceManager instance;
    private Map<CustomFont, String> fontPaths = new HashMap<>();
    private Map<CustomFont, Font> fonts = new HashMap<>();

    private Map<CustomAudioClip, String> audioPaths = new HashMap<>();
    private Map<CustomAudioClip, AudioClip> audio = new HashMap<>();

    private Map<CustomMedia, String> mediaPaths = new HashMap<>();
    private Map<CustomMedia, MediaPlayer> media = new HashMap<>();

    private AudioClip currentClipPlaying;
    private MediaPlayer currentMediaPlayer;

    private ResourceManager() {
        fontPaths.put(CustomFont.Ken, Config.MAIN_FONT_PATH);
        audioPaths.put(CustomAudioClip.SFXLaser01, Config.SFXLASER01);
        mediaPaths.put(CustomMedia.MenuSong01, Config.SONG_BILLY);
    }

    public static ResourceManager getInstance() {
        if (instance == null) instance = new ResourceManager();
        return instance;
    }

    public void LoadResourcesFor(Purpose purpose) {
        switch (purpose) {
            case Splash:
                if (fonts != null) {
                    fonts.clear();
                    fonts.put(CustomFont.Ken, loadFont(fontPaths.get(CustomFont.Ken), 60));
                }
                break;
            case MainMenu:
                if (fonts != null) {
                    fonts.clear();
                    fonts.put(CustomFont.Ken, loadFont(fontPaths.get(CustomFont.Ken), 48));
                }
                if (media != null) {
                    media.clear();
                    loadMedia(CustomMedia.MenuSong01);
                }
                break;
            case OptionsMenu:
                if (fonts != null) {
                    fonts.clear();
                    fonts.put(CustomFont.Ken, loadFont(fontPaths.get(CustomFont.Ken), 48));
                }
                break;
            case LoadingScreen:
                break;
            case Level:
                break;
            case PauseMenu:
                break;
        }
    }

    private Font loadFont(String path, int size) {
        Font font = null;
        try (FileInputStream fis = new FileInputStream(path)) {
            font = Font.loadFont(fis, size);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return font;
    }

    public Font getFont(CustomFont font) {
        return fonts.get(font);
    }

    public void playAudioClip(CustomAudioClip audioClip) {
        if (currentClipPlaying != null) {
            currentClipPlaying.stop();
        }

        currentClipPlaying = audio.get(audioClip);
        currentClipPlaying.play();
    }

    public void stopAudioClip(CustomAudioClip audioClip) {
        if (currentClipPlaying != null) {
            currentClipPlaying.stop();
        }
    }

    public void playMedia(CustomMedia media) {
        if (currentMediaPlayer != null) {
            currentMediaPlayer.stop();
        }

        currentMediaPlayer = this.media.get(media);
        currentMediaPlayer.play();
    }

    public void pauseMedia() {
        if (currentMediaPlayer != null) {
            currentMediaPlayer.pause();
        }
    }

    public void stopMedia() {
        if (currentMediaPlayer != null) {
            currentMediaPlayer.stop();
        }
    }

    public void resumeMedia() {
        if (currentMediaPlayer != null) {
            currentMediaPlayer.play();
        }
    }

    private void loadMedia(CustomMedia media) {
        URL url = ClassLoader.getSystemResource(mediaPaths.get(media));
        String path;

        if (url == null) path = new File(mediaPaths.get(media)).toURI().toString();
        else path = url.toString();

        this.media.put(media, new MediaPlayer(new Media(path)));
    }

    public enum Purpose {
        Splash,
        MainMenu,
        OptionsMenu,
        LoadingScreen,
        Level,
        PauseMenu
    }

    public enum CustomFont {
        Ken
    }

    public enum CustomAudioClip {
        SFXLaser01
    }

    public enum CustomMedia {
        MenuSong01
    }
}
