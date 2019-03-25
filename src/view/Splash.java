package view;

import game.GameData;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import manager.ResourceManager;

public class Splash extends BaseView {

    private String message;
    private GameData data;

    public Splash(GameData data, String message) {
        super(data);
        data.getResourceManager().LoadResourcesFor(ResourceManager.Purpose.Splash);
        this.data = data;
        this.message = message;
    }

    @Override
    public void Draw() {
        gfx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @Override
    public void Init() {
        data.setCanvas(canvas);
        data.setGfx(canvas.getGraphicsContext2D());
        data.replaceRootCanvas(canvas);

        Text splashText = new Text(message);
        splashText.setFont(ResourceManager.getInstance().getFont(ResourceManager.CustomFont.Ken));
        splashText.setFill(Color.RED);
        splashText.setStroke(Color.BLACK);
        centerTextToScene(splashText);
        root.getChildren().add(splashText);
    }

    @Override
    public void IncrementIndex() {
        // nothing
    }

    @Override
    public void DecrementIndex() {
        // nothing
    }

    @Override
    public void ExecuteCurrentOption() {

    }
}
