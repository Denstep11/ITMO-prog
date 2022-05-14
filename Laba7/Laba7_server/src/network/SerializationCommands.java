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
    private String login;
    private String password;
    private Boolean authorization=false;
    private Boolean registration=false;
    private int port;

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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorization(Boolean authorization) {
        this.authorization = authorization;
    }

    public void setRegistration(Boolean registration) {
        this.registration = registration;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Boolean getAuthorization() {
        return authorization;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getRegistration() {
        return registration;
    }

    public int getPort() {
        return port;
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
