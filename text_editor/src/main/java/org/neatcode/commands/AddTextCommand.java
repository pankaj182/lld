package org.neatcode;

public class AddTextCommand implements Command {
    private Document document;
    private String text;

    public AddTextCommand(Document document, String text) {
        this.document = document;
        this.text = text;
    }

    @Override
    public void execute() {
        document.addText(text);
    }

    @Override
    public void undo() {
        document.deleteText(text.length());
    }
}
