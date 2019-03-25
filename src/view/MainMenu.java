package view;

import config.Config;
import game.GameData;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import manager.ResourceManager;

public class MainMenu extends BaseView {
    private Text startGame = null;
    private GameData data;

    public MainMenu(GameData data) {
        super(data);
        data.getResourceManager().LoadResourcesFor(ResourceManager.Purpose.MainMenu);
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

        startGame = new Text(Config.MAIN_MENU_START_GAME);
        startGame.setFill(Color.RED);
        startGame.setStroke(Color.BLACK);
        startGame.setFont(ResourceManager.getInstance().getFont(ResourceManager.CustomFont.Ken));
        centerTextToScene(startGame);
        root.getChildren().add(startGame);
    }
}
