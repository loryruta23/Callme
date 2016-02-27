package org.unnamed_1.server;

import org.unnamed_1.server.commands.Exit;
import org.unnamed_1.server.commands.List;

public class Callme {

    private static Server server;
    private static InputManager inputManager;

    public static void main(String[] args) {
        server = new Server(9090);

        inputManager = new InputManager();
        inputManager.getCommandManager().addCommand(new Exit());
        inputManager.getCommandManager().addCommand(new List());
        inputManager.start();
    }

    public static void exit(long sleep) {
        new Thread(() -> {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ignored) {
            }
            server.exit();
            System.exit(0);
        }).start();
    }

    public static Server getServer() {
        return server;
    }

    public static InputManager getInputManager() {
        return inputManager;
    }
}
