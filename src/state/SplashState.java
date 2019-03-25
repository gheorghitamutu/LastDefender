package state;

import game.GameData;
import javafx.application.Platform;
import javafx.scene.Scene;
import view.Splash;

public class SplashState implements BaseState {
    private final GameData data;
    private long startNanoTime = 0;
    private Splash splashView;
    private final boolean quitGameSplash;

    public SplashState(GameData data, String message, boolean quitGameSplash) {
        super();
        this.data = data;
        splashView = new Splash(this.data, message);
        this.quitGameSplash = quitGameSplash;
    }

    @Override
    public void HandleInput() {
        // implement controller
    }

    @Override
    public void Update() {
        double delta = (System.nanoTime() - startNanoTime) / 1000000000.0;
        if (delta > splashView.getLifeSpan()) {
            if (quitGameSplash) {
                Platform.exit();
            }
            data.getStateMachine().AddState(new MainMenuState(data), true);
        }
    }

    @Override
    public void Draw() {
        splashView.Draw();
    }

    @Override
    public void init() {
        startNanoTime = System.nanoTime();
        splashView.Init();
    }

    @Override
    public void pause() {
        // no pause on this state
    }

    @Override
    public void resume() {
        data.setCanvas(splashView.getCanvas());
        data.setGfx(splashView.getCanvas().getGraphicsContext2D());
        data.replaceRootCanvas(splashView.getCanvas());
    }

    @Override
    public Scene GetScene() {
        return splashView.getScene();
    }
}
