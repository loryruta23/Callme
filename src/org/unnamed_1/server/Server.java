package org.unnamed_1.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server extends Thread {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9090);
        } catch (IOException ignored) {
        }
    }


}
