package com.company;

import network.Client;
import network.CommandControl;
import network.SerializationCommands;

import java.io.IOException;
import java.util.Scanner;
/**
 * @author Denis Baranov
 * @version 1.0
 */

public class ClientApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String login;
        String password;
        String command;
        String reg;
        CommandControl commandControl = new CommandControl();
        while (true){
            System.out.println("Есть аккаунт?[да/нет]");
            reg = in.nextLine();
            if(reg.equals("нет")|| reg.equals("да")){
                break;
            }
        }
        while (true){
            SerializationCommands logpas = new SerializationCommands();
            if(reg.equals("нет")){
                System.out.println("Зарегистрируйтесь");
                logpas.setRegistration(true);
            }
            else if(reg.equals("да")){
                logpas.setRegistration(false);
            }
            System.out.print("Введите логин:");
            login = in.nextLine();
            System.out.print("Введите пароль:");
            password = in.nextLine();
            Client.login=login;
            Client.password=password;
            logpas.setAuthorization(true);
            try {
                Client.send(logpas);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(Client.receive().equals("true")){
                    System.out.println("Добро пожаловать");
                    break;
                }
                else if(reg.equals("нет")){
                    System.out.println("Данный лоигн уже занят");
                }
                else {
                    System.out.println("Неверный логин или пароль!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (true){
            try {
                System.out.print(">>>");
                command = in.nextLine();
                if(command.equals("exit")){
                    System.out.println("Конец работы");
                    break;
                }else {
                    commandControl.handlecommand(command,in,true);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
