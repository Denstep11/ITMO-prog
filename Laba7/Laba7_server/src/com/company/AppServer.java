package com.company;

import commands.Exit;
import exсeptions.NullExсeption;
import exсeptions.SpeedExсeption;
import network.Server;
import util.*;

import java.io.IOException;
import java.sql.*;

/**
 * @author Denis Baranov
 * @version 1.0
 */

public class AppServer {
    /**
     *Here start point of the program
     * @param args command line values
     */
    public static void main(String[] args){
        try {
            FileControl fileControl = new FileControl();
            Updatedb.conn = DriverManager.getConnection("jdbc:postgresql://localhost/Humans", "postgres", "DenDenvv");
            Updatedb.statement = Updatedb.conn.createStatement();
            ResultSet serial = Updatedb.statement.executeQuery("SELECT setval('serial',(SELECT max(id) FROM humans))");
            while (serial.next()){
                Collection.id=serial.getLong(1);
            }
            ResultSet res = Updatedb.statement.executeQuery("SELECT*FROM humans");
           // fileControl.readln(Collection.address);
           // ParserControl parserControl = new ParserControl(fileControl.st);
            CollectionControl collectionControl = new CollectionControl();
            Collection.tree = collectionControl.newcollection(res);
        } catch (NullExсeption | SpeedExсeption ex) {
            System.out.println("Некорректное содержимое файла");
            Exit.run = false;
        } catch (Exception ex) {
            Exit.run = false;
            System.err.println(ex);
            System.out.println("чтото пошло");
        }

        try {
            Server server = new Server();
            while (true){
                server.run();
            }
        } catch (IOException | ClassNotFoundException e) {}
    }
}
