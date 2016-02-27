package org.unnamed_1.server;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public byte[] read() {
        int length;
        try {
            length = socket.getInputStream().read();
        } catch (IOException exception) {
            throw new IllegalStateException("The connection is closed: " + exception);
        }
        byte[] data = new byte[length];
        try {
            socket.getInputStream().read(data);
        } catch (IOException e) {
            throw new IllegalStateException("The connection ")
        }

    }

    public void write(byte[] data) {

    }
}
