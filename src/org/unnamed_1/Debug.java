package org.unnamed_1;


import java.io.PrintStream;

public enum Debug {

    RESET("\u001B[0m", false),
    SUCCESS("\u001B[32m", false),
    INFO("\u001B[34m", false),
    WARNING("\u001B[33m", true),
    ERROR("\u001B[31m", true);

    private final String color;
    private final boolean error;

    Debug(String color, boolean error) {
        this.color = color;
        this.error = error;
    }

    private PrintStream getPrintStream() {
        return error ? System.err : System.out;
    }

    public static void print(Debug type, String message) {
        type.getPrintStream().print(type.color + "[" + type.name() + "] " + message + RESET.color);
    }

    public static void println(Debug type, String message) {
        print(type, message + "\n");
    }
}
