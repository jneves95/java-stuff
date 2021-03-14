package com.company.memento;

/**
 * In our Main class we can observe how our Editor object never depends on any History objects. It simply creates or retrieves EditorState objects for and from our History.
 */
public class Main {
    public static void main(String[] args) {
        var editor = new Editor();
        var history = new History();

        editor.setContent("a");
        history.push(editor.createState());
        editor.setContent("b");
        history.push(editor.createState());
        editor.setContent("c");

        System.out.println(editor.getContent()); // c
        editor.restore(history.undo());
        editor.restore(history.undo());
        System.out.println(editor.getContent()); // a
        editor.restore(history.redo());
        System.out.println(editor.getContent()); // b
        editor.restore(history.undo());
        editor.restore(history.undo());
        System.out.println(editor.getContent()); // a
        editor.setContent("d");
        history.push(editor.createState());
        editor.setContent("e");
        history.push(editor.createState());
        System.out.println(editor.getContent()); // e
        editor.restore(history.undo());
        editor.restore(history.undo());
        System.out.println(editor.getContent()); // a
        editor.restore(history.redo());
        System.out.println(editor.getContent()); // d
    }
}
