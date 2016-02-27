package org.unnamed_1.server;

public class Callme {

    private static Server server;
    private static InputManager inputManager;

    public static void main(String[] args) {
        server = new Server(9090);
        inputManager = new InputManager();
        inputManager.start();
    }

    public static Server getServer() {
        return server;
    }

    public static InputManager getInputManager() {
        return inputManager;
    }
}
