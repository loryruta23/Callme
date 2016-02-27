package org.unnamed_1.server;

import java.io.IOException;
import java.io.InputStream;
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
                InputStream in = socket.getInputStream();
                int length = in.read();
                byte[] data = new byte[length];

                clients.add();
            } catch (IOException ignored) {

            }
        }
    }
}
