package org.unnamed_1.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private final ServerSocket server;
    private final Communication communication;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot host a local server on port 9090: " + exception);
        }
        this.communication = new Communication(this);
    }

    public ServerSocket getSocket() {
        return server;
    }
}
