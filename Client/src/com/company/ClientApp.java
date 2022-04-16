package com.company;

import network.CommandControl;

import java.io.IOException;
import java.util.Scanner;
/**
 * @author Denis Baranov
 * @version 1.0
 */

public class ClientApp {
    /**
     *Here start point of the program
     * @param args command line values
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        CommandControl commandControl = new CommandControl();
        while (true){
            try {
                System.out.print(">>>");
                str = in.nextLine();
                if(str.equals("exit")){
                    System.out.println("Конец работы");
                    break;
                }else {
                    commandControl.handlecommand(str,in,true);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
