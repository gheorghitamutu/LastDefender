package main;

import config.Config;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import view.TestView;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(Config.GAME_TITLE);

        TestView tv = new TestView(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        tv.Draw();
        primaryStage.setScene(tv.getScene());

        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double delta = (currentNanoTime - startNanoTime) / 1000000000.0;
                if (delta > tv.getLifeSpan())
                    primaryStage.close();
                tv.Draw();
            }
        }.start();

        primaryStage.show();
    }
}
