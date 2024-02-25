package org.neatcode;

public class Main {
    public static void main(String[] args) {
        Document document = new Document();
        TextEditor textEditor = new TextEditor(document);

        // Add some text
        textEditor.addText("Hello, ");
        textEditor.addText("world!");

        textEditor.display();

        // Undo adding text
        textEditor.undo();
        textEditor.display();

        // Redo adding text
        textEditor.redo();
        textEditor.display();

        // Delete some text
        textEditor.deleteText(6);
        textEditor.display();

        // Move cursor
        textEditor.moveCursor(-2);
        textEditor.display();
    }
}