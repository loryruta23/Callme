package org.unnamed_1.client;

import org.unnamed_1.Debug;
import org.unnamed_1.LoginState;
import org.unnamed_1.client.exceptions.AlreadyUsedNameException;
import org.unnamed_1.client.exceptions.IllegalCharactersException;
import org.unnamed_1.utils.ByteUtil;

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

    private final Socket socket;

    public Client(String ip, int port) {
        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot connect to the server: " + e.toString());
        }
    }

    public void writePacket(byte[] packet) {
        try {
            socket.getOutputStream().write(packet.length);
            //first send the packet length(packet = byte[])
            socket.getOutputStream().write(packet);
            //then send the whole packet
            socket.getOutputStream().flush();
            //i don't even know what that should do but i think it make me sure that everything was sent successfully
        } catch (IOException e) {
            throw new IllegalStateException("Cannot send data to the server: " + e.toString());
        }
    }

    public User login(String name) throws AlreadyUsedNameException, IllegalCharactersException {
        writePacket(name.getBytes());
        int result = ByteUtil.toInt(readPacket());

        switch (result) {
            case LoginState.OK:
                return new User(this, name);

            case LoginState.ALREADY_USED_NAME:
                throw new AlreadyUsedNameException("Hey smilzo, be more original! That name is already used!");

            case LoginState.ILLEGAL_CHARACTERS:
                throw new IllegalCharactersException("Hey empty, you used some not-legal characters, thief!");

            default:
                throw new IllegalStateException("Something went wrong, I'm sorry (eh eh!)");
        }
    }

    public byte[] readPacket() {
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
            int result = socket.getInputStream().read(data, 0, length); //read data from 0 to max(length)
            if (result == -1)
                return new byte[0];
        } catch (IOException exception) {
            throw new IllegalStateException("Something wrong during data reading: " + exception);
        }
        return data;
    }

}
