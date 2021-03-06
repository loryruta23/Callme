package org.unnamed_1.server;

import org.unnamed_1.CommandManager;
import org.unnamed_1.Debug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager extends Thread {

    private final CommandManager commandManager;
    private final BufferedReader reader;

    public InputManager() {
        commandManager = new CommandManager();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (isAlive()) {
            String command;
            try {
                command = reader.readLine();
            } catch (IOException exception) {
                Debug.println(Debug.ERROR, "Command syntax error, try again: " + exception);
                continue;
            }
            String name, args[];
            if (command.startsWith("/")) {
                String[] _command = command.split(" ");
                name = _command[0].substring(1);
                args = new String[_command.length - 1];
                System.arraycopy(_command, 1, args, 0, args.length);
            } else {
                Debug.println(Debug.ERROR, "Invalid action, all commands should starts with '/'.");
                continue;
            }
            if (!commandManager.execute(name, args))
                Debug.println(Debug.ERROR, "Command not found, type /help for more info.");
        }
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}
