package state;

import config.Config;
import javafx.application.Platform;
import javafx.scene.Scene;
import view.Splash;

public class SplashState implements BaseState {
    private final long startNanoTime = System.nanoTime();
    private Splash splashView = new Splash(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
    private long delta = 0;

    @Override
    public void handle_input() {
        // implement controller
    }

    @Override
    public void update() {
        delta += (System.nanoTime() - startNanoTime) / 1000000000.0;
        if (delta > splashView.getLifeSpan()) {
            Platform.exit();
        } else {
            handle_input(); // controller to switch state
        }
    }

    @Override
    public void draw() {
        splashView.draw();
    }

    @Override
    public void init() {
        // nothing to initialize
    }

    @Override
    public void pause() {
        // no pause on this state
    }

    @Override
    public void resume() {
        // no resume on this state
    }

    public Scene getScene() {
        return splashView.getScene();
    }
}
