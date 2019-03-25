package game;

import config.Config;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import manager.ResourceManager;
import state.StateMachine;

public class GameData {

    private StateMachine stateMachine = new StateMachine();
    private Canvas canvas = new Canvas(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
    private GraphicsContext gfx = canvas.getGraphicsContext2D();
    private Group root = new Group();
    private Scene scene;
    private ResourceManager resourceManager = ResourceManager.getInstance();
    // input manager??

    GameData() {
        root.getChildren().add(canvas);
        scene = new Scene(root);
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public GraphicsContext getGfx() {
        return gfx;
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public void setResourceManager(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
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

    public Scene getScene() {
        return scene;
    }

    public void replaceRootCanvas(Canvas canvas) {
        root.getChildren().clear();
        root.getChildren().add(canvas);
    }
}
