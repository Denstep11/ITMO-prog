package com.company;

import commands.Exit;
import commands.Save;
import exсeptions.NullExсeption;
import exсeptions.SpeedExсeption;
import network.Server;
import util.*;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Denis Baranov
 * @version 1.0
 */

public class AppServer {
    /**
     *Here start point of the program
     * @param args command line values
     */
    public static void main(String[] args) {
        FileControl fileControl = new FileControl();
        Scanner in = new Scanner(System.in);
        try {
            fileControl.readln(Collection.address);
            ParserControl parserControl = new ParserControl(fileControl.st);
            CollectionControl collectionControl = new CollectionControl();
            Collection.tree = collectionControl.newcollection(parserControl.content);
        } catch (NullExсeption | SpeedExсeption ex) {
            System.out.println("Некорректное содержимое файла");
            Exit.run = false;
        } catch (Exception ex) {
            Exit.run = false;
        }

        try {
            Server server = new Server();
            while (true){
                server.run();
            }
        } catch (IOException | ClassNotFoundException e) {}
    }
}
