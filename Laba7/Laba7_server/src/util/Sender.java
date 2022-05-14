package util;

import network.SerializationCommands;
import network.Server;

import java.io.IOException;

public class Sender implements Runnable{
    private String answer;
    private SerializationCommands serializationCommands;
    public Sender(String answer, SerializationCommands serializationCommands){
        this.answer=answer;
        this.serializationCommands=serializationCommands;
    }
    @Override
    public void run() {
        try {
            Server.send(answer, serializationCommands.getPort());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
