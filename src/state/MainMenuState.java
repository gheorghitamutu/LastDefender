package state;

import controller.MainMenuController;
import game.GameData;
import javafx.scene.Scene;
import manager.ResourceManager;
import view.MainMenu;

public class MainMenuState implements BaseState {

    private final GameData data;
    private final MainMenu mainMenu;
    private final MainMenuController mainMenuController;

    MainMenuState(GameData data) {
        super();
        this.data = data;
        mainMenu = new MainMenu(this.data);
        mainMenuController = new MainMenuController(mainMenu);
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
        mainMenuController.AddListeners();
        data.getResourceManager().playMedia(ResourceManager.CustomMedia.MenuSong01);
    }

    @Override
    public void pause() {
        mainMenuController.RemoveListeners();
        data.getResourceManager().pauseMedia();
    }

    @Override
    public void resume() {
        data.setCanvas(mainMenu.getCanvas());
        data.setGfx(mainMenu.getCanvas().getGraphicsContext2D());
        data.replaceRootCanvas(mainMenu.getCanvas());
        mainMenuController.AddListeners();
        mainMenu.AddRootChildren();
        data.getResourceManager().resumeMedia();
    }

    @Override
    public Scene GetScene() {
        return mainMenu.getScene();
    }
}
