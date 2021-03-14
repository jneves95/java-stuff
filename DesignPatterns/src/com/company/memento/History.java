package com.company.memento;

import java.util.LinkedList;
import java.util.List;

/**
 * In our History class, we have a list of EditorState objects, these are completely dependent on the History object, they don't exist without it.
 */
public class History {
    private List<EditorState> states;
    private int current;

    public History () {
        states = new LinkedList<>();
        current = 0;
    }

    // Removes (forgets) any states forward from the current one, and adds a new state
    public void push(EditorState state) {
        if (current < states.size() - 1) {
            for (int i = states.size() - 1; i > current; i--) {
                states.remove(i);
            }
        }
        states.add(state);
        current++;
    }

    // This method became obsolete when we implemented the redo function, since we want to remember undone states until the next time we add a new state
    public EditorState pop() {
        var lastIndex = states.size() - 1;
        if (lastIndex >= 0) {
            var state = states.get(states.size()-1);
            states.remove(state);
            return state;
        }
        return null;
    }

    // Navigates backward in our list
    public EditorState undo() {
        if (current > 0) current--;
        return states.get(current);
    }

    // Navigates forward in our list
    public EditorState redo() {
        if (current < states.size() - 1) current++;
        return states.get(current);
    }
}
