package state;

import game.GameData;
import javafx.scene.Scene;
import view.MainMenu;

public class MainMenuState implements BaseState {
    private final GameData data;
    private MainMenu mainMenu;

    MainMenuState(GameData data) {
        super();
        this.data = data;
        mainMenu = new MainMenu(this.data);
    }

    @Override
    public void HandleInput() {

    }

    @Override
    public void Update() {
        // logic for menu selection
    }

    @Override
    public void Draw() {
        mainMenu.Draw();
    }

    @Override
    public void init() {
        mainMenu.Init();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
        data.setCanvas(mainMenu.getCanvas());
        data.setGfx(mainMenu.getCanvas().getGraphicsContext2D());
        data.replaceRootCanvas(mainMenu.getCanvas());
    }

    @Override
    public Scene GetScene() {
        return mainMenu.getScene();
    }
}
