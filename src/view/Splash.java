package view;

import config.Config;
import game.GameData;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import manager.ResourceManager;

public class Splash extends BaseView {

    private Text splashMessage;
    private GameData data;

    public Splash(GameData data) {
        super(data);
        data.getResourceManager().LoadResourcesFor(ResourceManager.Purpose.Splash);
        this.data = data;
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

        splashMessage = new Text(Config.GAME_TITLE);
        splashMessage.setFont(ResourceManager.getInstance().getFont(ResourceManager.CustomFont.Ken));
        splashMessage.setFill(Color.RED);
        splashMessage.setStroke(Color.BLACK);
        centerTextToScene(splashMessage);
        root.getChildren().add(splashMessage);
    }
}
