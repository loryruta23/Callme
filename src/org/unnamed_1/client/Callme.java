package org.unnamed_1.client;

import org.unnamed_1.Command;
import org.unnamed_1.CommandManager;
import org.unnamed_1.Debug;
import org.unnamed_1.client.exceptions.AlreadyUsedNameException;
import org.unnamed_1.client.exceptions.IllegalCharactersException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Callme {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ip;

        while (true) {
            Debug.print(Debug.INFO, "Type your destination ip: ");
            try {
                ip = reader.readLine();
                break;
            } catch (IOException ignored) {
                Debug.println(Debug.ERROR, "You typed a wrong ip!");
            }
        }
        Client client = new Client(ip, 9090);
        Debug.println(Debug.SUCCESS, "Successfully connected to the server!");

        String username;
        while (true) {
            System.out.print("Type your name:");
            try {
                username = reader.readLine();
                client.login(username);
                break;
            } catch (IOException ignored) {
                System.err.println("You typed an invalid username!");
            } catch (AlreadyUsedNameException e) {
                System.out.println("You used an already-used username! Oh, did I say 'used'?");
            } catch (IllegalCharactersException e) {
                System.out.println("You used some illegal characters in the username.");
            }
            Debug.println(Debug.SUCCESS, "Successfully logged in.");
        }

        //never trust clients. Just servers.

        while(true) {
            String command = reader.readLine();
        }
    }
}
