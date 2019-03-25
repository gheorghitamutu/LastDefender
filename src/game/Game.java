package game;

import config.Config;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import state.SplashState;

public class Game extends Application {
    private final double deltaTime = 0.16;
    private GameData data = new GameData();

    public Game() {
        super();
        data.getStateMachine().AddState(new SplashState(data, Config.GAME_TITLE, false), true);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(Config.GAME_TITLE);

        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });

        new AnimationTimer() {
            double accumulator = 0;
            double currentTime = System.nanoTime();

            public void handle(long currentNanoTime) {
                data.getStateMachine().ProcessStateChanges();

                double delta = (currentNanoTime - currentTime) / 1000000000.0;
                if (delta > deltaTime) {
                    delta = deltaTime;
                }

                currentTime = currentNanoTime;
                accumulator += delta;

                while (accumulator >= deltaTime) {
                    data.getStateMachine().getActiveState().HandleInput();
                    data.getStateMachine().getActiveState().Update();
                    accumulator -= deltaTime;
                }

                data.getStateMachine().getActiveState().Draw();
            }
        }.start();

        data.getStateMachine().ProcessStateChanges(); // make sure splash screen gets initialized
        primaryStage.setScene(data.getStateMachine().getActiveState().GetScene());
        primaryStage.show();
    }

    public void Run(String[] args) {
        launch(args);
    }

    enum GameProgress {
        Playing,
        Pause,
        Won,
        Lost
    }
}
