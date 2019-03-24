package manager;

import config.Config;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {

    private static ResourceManager instance;
    private Map<CustomFont, String> fontPaths = new HashMap<>();
    private Map<CustomFont, Font> fonts = new HashMap<>();

    private ResourceManager() {
        fontPaths.put(CustomFont.Ken, Config.MAIN_FONT_PATH);
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
                break;
            case OptionsMenu:
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
}
