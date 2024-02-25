package org.neatcode;

public class MoveCursorCommand implements Command {
    private Document document;
    private int steps;

    public MoveCursorCommand(Document document, int steps) {
        this.document = document;
        this.steps = steps;
    }

    @Override
    public void execute() {
        document.moveCursor(steps);
    }

    @Override
    public void undo() {
        // Moving cursor back in opposite direction
        document.moveCursor(-steps);
    }
}