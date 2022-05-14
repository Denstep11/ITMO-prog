package util;

import network.SerializationCommands;

import java.util.concurrent.RecursiveAction;

public class Treatment extends RecursiveAction {

    final SerializationCommands serialcomand;

    public Treatment(SerializationCommands serialcomand) {
        this.serialcomand=serialcomand;
    }

    @Override
    protected void compute() {
        String answer;
        ConsoleControl consoleControl = new ConsoleControl();
        Hashmd2 hashmd2 = new Hashmd2();
        serialcomand.setPassword(hashmd2.run(serialcomand.getPassword()));
        Usercheck usercheck = new Usercheck(serialcomand.getLogin(), serialcomand.getPassword());
        if(serialcomand.getAuthorization() && !serialcomand.getRegistration()){
            answer = usercheck.check();
        }
        else if(serialcomand.getAuthorization()&& serialcomand.getRegistration()){
            answer = usercheck.adduser();
        }
        else{
            answer = consoleControl.choice(serialcomand.toString(), serialcomand);
        }
        Sender sender = new Sender(answer,serialcomand);
        Thread sendthread = new Thread(sender);
        sendthread.start();
    }
}
