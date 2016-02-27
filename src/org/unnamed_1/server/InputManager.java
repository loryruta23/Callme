package org.unnamed_1.server;

import org.unnamed_1.CmdManager;
import org.unnamed_1.Debug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager extends Thread {

    private final CmdManager cmdManager;
    private final BufferedReader reader;

    public InputManager() {
        cmdManager = new CmdManager();
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
                name = _command[0];
                args = new String[_command.length - 1];
                System.arraycopy(_command, 1, args, 0, args.length);
            } else {
                Debug.println(Debug.ERROR, "Invalid action, all commands should starts with '/'.");
                continue;
            }
            if (!cmdManager.execute(name, args))
                Debug.println(Debug.ERROR, "Command not found, type /help for more info.");
        }
    }
}
