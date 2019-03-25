package state;

import javafx.scene.canvas.Canvas;

import java.util.Stack;

public class StateMachine {

    private Stack<BaseState> states = new Stack<>();
    private Stack<Canvas> canvases = new Stack<>();
    private BaseState newState = null;
    private boolean isRemoving = false;
    private boolean isAdding = false;
    private boolean isReplacing = false;

    public void AddState(BaseState newState, boolean isReplacing) {
        this.newState = newState;
        isAdding = true;
        this.isReplacing = isReplacing;
    }

    void RemoveState() {
        isRemoving = true;
    }

    public void ProcessStateChanges() {
        if (isRemoving && !states.empty()) {
            states.pop();

            if (!states.empty()) {
                states.peek().resume();
            }

            isRemoving = false;
        }

        if (isAdding) {
            if (!states.empty()) {
                if (isReplacing) {
                    states.peek().pause();
                    states.pop();
                } else {
                    states.peek().pause();
                }
            }

            states.push(newState);
            states.peek().init();
            isAdding = false;
        }
    }

    public BaseState getActiveState() {
        return states.peek();
    }
}
