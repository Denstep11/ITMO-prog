package com.company;

import commands.Exit;
import exeptions.NullExeption;
import exeptions.SpeedExeption;
import util.*;

import java.util.Scanner;

/**
 * @author Denis Baranov
 * @version 1.0
 */

public class Main {
    /**
     * Here start point of the program
     * @param args command line values
     */
    public static void main(String[] args) {

        FileControl fileControl = new FileControl();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите адрес файла:");
        Collection.address = in.nextLine();
        try {
            fileControl.readln(Collection.address);
            ParserControl parserControl = new ParserControl(fileControl.st);
            CollectionControl collectionControl = new CollectionControl();
            Collection.tree = collectionControl.newcollection(parserControl.content);
        } catch (NullExeption | SpeedExeption ex) {
            System.out.println("Некорректное содержимое файла");
            Exit.run = false;
        } catch (Exception ex) {
            Exit.run = false;
        }

        ConsoleControl consoleControl = new ConsoleControl();
        while (Exit.run) {
            System.out.print(">>>");
            String comand = in.nextLine();
            try {
                consoleControl.choice(comand, in, true);
            } catch (Throwable t) {
                System.out.println("Некорректный ввод данных!");
            }
        }
    }
}
