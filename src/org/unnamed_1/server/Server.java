package org.unnamed_1.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private final ServerSocket server;
    private final Communication communication;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started! pt.2");
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot host a local server on the port" + port + ": " + exception);
        }
        this.communication = new Communication(this);
        communication.start();
    }

    public ServerSocket getSocket() {
        return server;
    }

    public Communication getCommunication() {
        return communication;
    }
}
