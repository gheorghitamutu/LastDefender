package view;

import config.Config;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import manager.ResourceManager;

public class Splash extends BaseView {

    public Splash(double width, double height) {
        super(width, height);
        ResourceManager.getInstance().LoadResourcesFor(ResourceManager.Purpose.Splash);
    }

    @Override
    public void draw() {
        gfx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Text splashMessage = new Text(Config.GAME_TITLE);
        splashMessage.setFont(ResourceManager.getInstance().getFont(ResourceManager.CustomFont.Ken));
        splashMessage.setFill(Color.RED);
        splashMessage.setStroke(Color.BLACK);
        centerTextToScene(splashMessage);
        root.getChildren().add(splashMessage);
    }
}
