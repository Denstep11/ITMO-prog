package network;

import data.Mood;
import util.CreationElement;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * selects the command to be executed
 */
public class CommandControl {
    /**
     * choice command
     * @param command commands
     * @param in scanner
     * @param fromCommandLine boolean from command line
     */

    public void handlecommand(String command, Scanner in, Boolean fromCommandLine) throws IOException {
        String[] elements = command.split(" ");
        switch (elements[0]) {
            case "help":
            case "info":
            case "show":
            case "clear":
            case "history":
            case "min_by_weapon_type":
            case "group_counting_by_impact_speed":
                Client.send(new SerializationCommands(elements[0]));
                System.out.println(Client.receive());
                break;
            case "count_greater_than_mood":
                Mood[] mood = Mood.values();
                try {
                    for(Mood m: mood) {
                        if (Mood.valueOf(elements[1]) == m) {
                            Client.send(new SerializationCommands(elements[0], elements[1]));
                            System.out.println(Client.receive());
                        }
                    }
                }
                catch (Exception e){
                    System.out.println("Некорректное значение аргумента!");
                    System.out.println("Возможнын аргументы: SADNESS, LONGING, GLOOM,FRENZY");
                }
                break;
            case "add_if_min":
            case "add":
            case "remove_lower":
                try {
                    Client.send(new SerializationCommands(elements[0],CreationElement.create(in,fromCommandLine)));
                    System.out.println(Client.receive());
                }
                catch (Exception e){
                    System.out.println("Некорректное значение аргумента!");
                }
                break;
            case "update":
                try {
                    Integer.parseInt(elements[1]);
                    Client.send(new SerializationCommands(elements[0],elements[1],CreationElement.create(in,fromCommandLine)));
                    System.out.println(Client.receive());
                }
                catch (Exception e){
                    System.out.println("Некорректное значение аргумента!");
                }
                break;
            case "remove_by_id":
                try {
                    Integer.parseInt(elements[1]);
                    Client.send(new SerializationCommands(elements[0],elements[1]));
                    System.out.println(Client.receive());
                }
                catch (Exception e){
                    System.out.println("Некорректное значение аргумента!");
                }
                break;
            case "execute_script":
                try {
                    FileReader reader = new FileReader(new File(elements[1]));
                    Scanner scan = new Scanner(reader);
                    while (scan.hasNextLine()) {
                        CommandControl commandControl = new CommandControl();
                        commandControl.handlecommand(scan.nextLine(),scan,false);
                    }
                } catch (Exception ex) {
                    System.out.println("Ошибка чтения файла, проверьте адрес файла!");
                }
                break;
            case "":
                break;
            default:
                System.out.println("Неизвестная команда, введите help - чтбы получить список комманд!");
                break;
        }
    }
}
