package state;

public interface BaseState {
    void handle_input();

    void update();

    void draw();

    void init();

    void pause();

    void resume();
}
