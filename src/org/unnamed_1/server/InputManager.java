package org.unnamed_1.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputManager extends Thread {

    private final BufferedReader reader;

    public InputManager() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {

        }
    }
}
