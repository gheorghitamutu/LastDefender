package state;

import java.util.Stack;

public class StateMachine {

    private Stack<BaseState> states = new Stack<>();
    private BaseState baseState = null;
    private boolean isRemoving = false;
    private boolean isAdding = false;
    private boolean isReplacing = false;

    void add_state(BaseState newState, boolean isReplacing) {

    }

    void remove_state() {

    }

    void process_state_changes() {

    }

    BaseState getActiveState() {
        return null;
    }
}
