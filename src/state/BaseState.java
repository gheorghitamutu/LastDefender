package state;

import javafx.scene.Scene;

public interface BaseState {
    void HandleInput();

    void Update();

    void Draw();

    void init();

    void pause();

    void resume();

    Scene GetScene();
}
