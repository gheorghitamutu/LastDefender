package controller;

import javafx.scene.input.KeyEvent;
import view.BaseView;

public class MainMenuController extends BaseController {
    private BaseView view;

    public MainMenuController(BaseView view) {
        this.view = view;
    }

    public void AddListeners() {
        view.getScene().addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            switch (key.getCode()) {
                case ENTER:
                    view.ExecuteCurrentOption();
                    break;
                case DOWN:
                    view.IncrementIndex();
                    break;
                case UP:
                    view.DecrementIndex();
                    break;
                default:
                    break;
            }
        });
    }
}
