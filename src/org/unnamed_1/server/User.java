package org.unnamed_1.server;

public class User {

    private final Client client;
    private final String name;

    public User(Client client, String name) {
        this.client = client;
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public String getName() {
        return name;
    }
}
