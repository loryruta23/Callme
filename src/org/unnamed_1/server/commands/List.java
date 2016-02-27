package org.unnamed_1.server.commands;

import org.unnamed_1.Command;
import org.unnamed_1.Debug;
import org.unnamed_1.server.Callme;
import org.unnamed_1.server.User;

public class List extends Command {

    public List() {
        super("list");
    }

    @Override
    public void onExecute(String[] args) {
        if (args.length != 0) {
            Debug.println(Debug.ERROR, "You've typed too many arguments!");
            return;
        }
        java.util.List<User> users = Callme.getServer().getCommunication().getUsers();
        String out;
        if (users.size() > 0) {
            out = "Found " + users.size() + " users, here's their data [ip|name]:";
            for (User user : users)
                out += "\n- " + user.getClient().getSocket().getInetAddress().getHostName() + " " + user.getName();
        } else {
            out = "There's no user connected to the server.";
        }
        Debug.println(Debug.INFO, out);
    }
}
