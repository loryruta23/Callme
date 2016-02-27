package org.unnamed_1.server.commands;

import org.unnamed_1.server.Callme;

public class Exit extends Command {

    public Exit() {
        super("exit");
    }

    @Override
    public void onExecute(String[] args) {
        if (args.length != 0) {
            System.err.println("You've typed too many arguments!");
            return;
        }
        Callme.getServer().exit();
    }
}