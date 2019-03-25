package state;

import controller.OptionsController;
import game.GameData;
import javafx.scene.Scene;
import view.Options;

public class OptionsState implements BaseState {

    private final GameData data;
    private final Options optionsMenu;
    private final OptionsController optionsController;

    public OptionsState(GameData data) {
        super();
        this.data = data;
        optionsMenu = new Options(this.data);
        optionsController = new OptionsController(optionsMenu);
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
        optionsMenu.Draw();
    }

    @Override
    public void init() {
        optionsMenu.Init();
        optionsController.AddListeners();
    }

    @Override
    public void pause() {
        optionsController.RemoveListeners();
    }

    @Override
    public void resume() {
        data.setCanvas(optionsMenu.getCanvas());
        data.setGfx(optionsMenu.getCanvas().getGraphicsContext2D());
        data.replaceRootCanvas(optionsMenu.getCanvas());
        optionsController.AddListeners();
        optionsMenu.AddRootChildren();
    }

    @Override
    public Scene GetScene() {
        return optionsMenu.getScene();
    }
}
