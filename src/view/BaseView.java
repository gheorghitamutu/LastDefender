package view;

import game.GameData;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Text;

abstract public class BaseView {
    Canvas canvas;
    GraphicsContext gfx;
    Group root;
    private Scene scene;
    private int lifeSpan = 3; // seconds

    BaseView(GameData data) {
        canvas = data.getCanvas();
        gfx = data.getGfx();
        root = data.getRoot();
        scene = data.getScene();
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

    void centerTextToScene(Text text) {
        text.layoutXProperty().bind(scene.widthProperty().subtract(text.prefWidth(-1)).divide(2));
        text.layoutYProperty().bind(scene.heightProperty().subtract(text.prefHeight(-1)).divide(2));
    }

    abstract public void Draw();

    abstract public void Init();

    abstract public void IncrementIndex();

    abstract public void DecrementIndex();

    public abstract void ExecuteCurrentOption();

    public abstract void AddRootChildren();
}
