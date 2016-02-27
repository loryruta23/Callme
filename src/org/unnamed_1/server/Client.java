package org.unnamed_1.server;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;

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
            if (length <= 0)
                return new byte[0];
        } catch (IOException exception) {
            throw new IllegalStateException("Something wrong during data reading: " + exception);
        }
        byte[] data = new byte[length];
        try {
            int result = socket.getInputStream().read(data, 0, length);
            if (result == -1)
                return new byte[0];
        } catch (IOException exception) {
            throw new IllegalStateException("Something wrong during data reading: " + exception);
        }
        return data;
    }

    public String readString() {
        return new String(read(), Charset.forName("UTF-8"));
    }

    public void write(byte[] data) {
    }
}
