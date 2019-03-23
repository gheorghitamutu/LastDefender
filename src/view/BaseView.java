package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class BaseView {
    Canvas canvas;
    GraphicsContext gfx;
    private Group root;
    private Scene scene;
    private int lifeSpan = 3; // seconds

    BaseView(double width, double height) {
        canvas = new Canvas(width, height);
        root = new Group();
        root.getChildren().add(canvas);
        scene = new Scene(root);
        gfx = canvas.getGraphicsContext2D();
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Group getRoot() {
        return root;
    }

    public void setRoot(Group root) {
        this.root = root;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public GraphicsContext getGfx() {
        return gfx;
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }
}
