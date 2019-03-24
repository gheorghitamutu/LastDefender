package main;

import config.Config;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import state.SplashState;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private SplashState splashState = new SplashState();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(Config.GAME_TITLE);

        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });

        new Thread(() -> {
            while (true) {
                splashState.update();
            }
        }).start();

        new AnimationTimer() {
            final long startNanoTime = System.nanoTime();
            double delta = 0;
            public void handle(long currentNanoTime) {
                delta += (currentNanoTime - startNanoTime) / 1000000000.0;
                if (delta > 0.16) {
                    splashState.draw();
                    delta -= 0.16;
                }
            }
        }.start();

        primaryStage.setScene(splashState.getScene());
        primaryStage.show();
    }
}
