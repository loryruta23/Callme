package org.unnamed_1.server;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Communication extends Thread {

    private final Server server;
    private final List<User> users = new LinkedList<>();

    public Communication(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        while (isAlive()) {
            try {
                Socket socket = server.getSocket().accept();

            } catch (IOException ignored) {

            }
        }
    }
}
