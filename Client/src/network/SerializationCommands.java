package network;

import data.HumanBeing;

import java.io.Serializable;
/**
 * Class for serialization
 */
public class SerializationCommands implements Serializable {
    String command;
    String argument;
    HumanBeing human;

    public SerializationCommands() {
    }

    public SerializationCommands(String command) {
        this.command = command;
    }

    public SerializationCommands(String command, String argument) {
        this.command = command;
        this.argument = argument;
    }

    public SerializationCommands(String command, String argument, HumanBeing human) {
        this.command = command;
        this.argument = argument;
        this.human = human;
    }

    public SerializationCommands(String command, HumanBeing human) {
        this.command = command;
        this.human = human;
    }

    public HumanBeing getHuman() {
        return human;
    }

    @Override
    public String toString() {
        if(argument == null) {
            return command;
        }
        else {
            return command+" "+argument;
        }
    }
}
