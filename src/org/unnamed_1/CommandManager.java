package org.unnamed_1;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public boolean execute(String name, String[] args) {
        for (Command command : commands) {
            if (command.getName().equalsIgnoreCase(name)) {
                command.onExecute(args);
                return true;
            }
        }
        return false;
    }
}
