package com.company.memento;

/**
 * To implement the memento pattern, we use an example of a text editor that has an Undo function and a Redo function (like ctrl+z and ctrl+y)
 *
 * As we can see, all the Editor class can do is restore (use) EditorState instances, but it is not in any way composed by these states.
 * We move that composition over to the History class.
 */
public class Editor {
    private String content;

    public Editor() {
        content = "";
    }

    public Editor(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EditorState createState() {
        return new EditorState(content);
    }

    public void restore(EditorState state) {
        if (state != null)
            content = state.getContent();
    }
}
