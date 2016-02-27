package org.unnamed_1.server;

import org.unnamed_1.Debug;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private final ServerSocket server;
    private final Communication communication;

    public Server(int port) {
        try {
            this.server = new ServerSocket(port);
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot host a local server on the port" + port + ": " + exception);
        }
        this.communication = new Communication(this);
        communication.start();
        Debug.println(Debug.SUCCESS, "Server initialized successfully!");
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
