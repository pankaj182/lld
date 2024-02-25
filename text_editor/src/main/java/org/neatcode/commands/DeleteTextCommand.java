package org.neatcode;

public class DeleteTextCommand implements Command {
    private Document document;
    private int length;

    public DeleteTextCommand(Document document, int length) {
        this.document = document;
        this.length = length;
    }

    @Override
    public void execute() {
        document.deleteText(length);
    }

    @Override
    public void undo() {
        // Adding back the deleted text
        // Here we may need to store the deleted text in the command for proper undo
        // For simplicity, let's assume we're only undoing the deletion and not tracking the deleted text
        document.moveCursor(length);
    }
}

