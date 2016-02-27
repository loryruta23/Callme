package org.unnamed_1.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private final int port;
    private final Communication communication;

    private ServerSocket server;

    public Server(int port) {
        this.port = port;
        this.communication = new Communication(this);
    }

    public void start() {
        try {
            server = new ServerSocket(port);
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot host a local server on the port" + port + ": " + exception);
        }
        communication.start();
    }

    public void exit() {
        communication.interrupt();
        try {
            server.close();
        } catch (IOException exception) {
            System.err.println("Error during server exiting: " + exception);
        }
    }

    public boolean isOnline() {
        return server != null;
    }

    public ServerSocket getSocket() {
        return server;
    }

    public Communication getCommunication() {
        return communication;
    }
}
