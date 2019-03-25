package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import view.BaseView;

public class OptionsController extends BaseController {

    private final EventHandler<KeyEvent> keyPressedEvent;
    private BaseView view;

    public OptionsController(BaseView view) {
        this.view = view;

        keyPressedEvent = keyEvent -> {
            switch (keyEvent.getCode()) {
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
        };
    }

    public void AddListeners() {
        view.getScene().addEventHandler(KeyEvent.KEY_PRESSED, keyPressedEvent);
    }

    public void RemoveListeners() {
        view.getScene().removeEventHandler(KeyEvent.KEY_PRESSED, keyPressedEvent);
    }
}
