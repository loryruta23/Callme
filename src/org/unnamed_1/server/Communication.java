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

    public List<User> getUsers() {
        return users;
    }

    @Override
    public void run() {
        while (isAlive()) {
            try {
                Socket socket = server.getSocket().accept();
                Client client = new Client(socket);
                String name = client.readString();
                users.add(new User(client, name));
            } catch (IOException ignored) {
            }
        }
    }
}
