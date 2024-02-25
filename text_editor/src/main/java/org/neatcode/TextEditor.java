package org.neatcode;

import org.neatcode.commands.AddTextCommand;
import org.neatcode.commands.Command;
import org.neatcode.commands.DeleteTextCommand;
import org.neatcode.commands.MoveCursorCommand;

import java.util.Stack;

public class TextEditor {
    private Document document;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public TextEditor(Document document) {
        this.document = document;
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void addText(String text) {
        Command command = new AddTextCommand(document, text);
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    public void deleteText(int length) {
        Command command = new DeleteTextCommand(document, length);
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    public void moveCursor(int steps) {
        Command command = new MoveCursorCommand(document, steps);
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

    public void display() {
        document.display();
    }
}
