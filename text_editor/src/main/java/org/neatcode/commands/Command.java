package org.neatcode.commands;

public interface Command {
    void execute();
    void undo();
}
