package org.unnamed_1.server;

public class Callme {

    private static Server server;

    public static void main(String[] args) {
        server = new Server(9090);
    }

    public static Server getServer() {
        return server;
    }
}
