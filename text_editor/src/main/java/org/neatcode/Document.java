package org.neatcode;

public class Document {
    private StringBuilder content;
    private int cursorPosition;

    public Document() {
        this.content = new StringBuilder();
        this.cursorPosition = 0;
    }

    public void addText(String text) {
        content.insert(cursorPosition, text);
        cursorPosition += text.length();
    }

    public void deleteText(int length) {
        if (cursorPosition - length >= 0) {
            content.delete(cursorPosition - length, cursorPosition);
            cursorPosition -= length;
        }
    }

    public void moveCursor(int steps) {
        int newPosition = cursorPosition + steps;
        if (newPosition >= 0 && newPosition <= content.length()) {
            cursorPosition = newPosition;
        }
    }

    public void display() {
        System.out.println("Current Content: " + content);
        System.out.println("Cursor Position: " + cursorPosition);
    }
}
