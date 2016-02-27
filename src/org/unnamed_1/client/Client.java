package org.unnamed_1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//Created by Alessandro on 27/02/2016.

//porta = ciò che riceve i pacchetti(dati) e li invia ad un processo
//socket = connessione che dal client va al server
//ip = codice non statico (in questo caso)
//InputStreamReader = canale in cui viaggiano i dati in INPUT

public class Client {
    public static void main(String[] args) {
        String ip;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Type your destination ip: ");
            try {
                ip = reader.readLine();
                break;
            } catch (IOException ignored) {
                System.err.println("You typed a wrong ip!");
            }
        }

        Socket socket;
        try {
            socket = new Socket(ip, 9090);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot connect to the server: " + e.toString());
        }
        System.out.print("Successfully connected to the server!");

        String username;
        while (true) {
            System.out.print("Type your name:");
            try {
                username = reader.readLine();
                break;
            } catch (IOException ignored) {
                System.err.println("You typed an invalid username!");
            }
        }

        try {
            socket.getOutputStream().write(username.length());
            //prima si invia la lunghezza del pacchetto (questo lo è)
            socket.getOutputStream().write(username.getBytes("UTF-8"));
            //ritorna "l'ASCII" di ogni lettera
        } catch (IOException e) {
            throw new IllegalStateException("Cannot send data to the server: " + e.toString());
        }
    }
}
