package view;

import config.Config;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import manager.ResourceManager;

public class MainMenu extends BaseView {
    public MainMenu(double width, double height) {
        super(width, height);
        ResourceManager.getInstance().LoadResourcesFor(ResourceManager.Purpose.MainMenu);
    }

    @Override
    public void draw() {
        gfx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Text startGame = new Text(Config.MAIN_MENU_START_GAME);
        startGame.setFill(Color.RED);
        startGame.setStroke(Color.BLACK);
        startGame.setFont(ResourceManager.getInstance().getFont(ResourceManager.CustomFont.Ken));
        centerTextToScene(startGame);
        root.getChildren().add(startGame);
    }
}
