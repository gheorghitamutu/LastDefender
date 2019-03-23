package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application {

    private GraphicsContext gfx;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dummy");

        Canvas canvas = new Canvas(800, 600);
        gfx = canvas.getGraphicsContext2D();

        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });

        primaryStage.show();
    }
}
