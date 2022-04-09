package util;

import commands.*;

import java.util.Scanner;

/**
 * selects the command to be executed
 */
public class ConsoleControl {
    /**
     * choice command
     * @param s command string(name)
     * @param scanner input stream
     * @param fromCommandLine information about input stream
     */
    public void choice(String s, Scanner scanner, Boolean fromCommandLine) {
        String[] elements = s.split(" ");
        switch (elements[0]) {
            case "help":
                Help.execute(scanner);
                break;
            case "info":
                Info.execute(scanner);
                break;
            case "show":
                Show.execute(scanner);
                break;
            case "add":
                Add.execute(scanner, fromCommandLine);
                break;
            case "update":
                UpdateId.execute(elements[1], scanner, fromCommandLine);
                break;
            case "remove_by_id":
                RemoveById.execute(elements[1], scanner);
                break;
            case "clear":
                Clear.execute(scanner);
                break;
            case "save":
                Save.execute(scanner);
                break;
            case "execute_script":
                ExecuteScript.execute(elements[1]);
                break;
            case "add_if_min":
                AddIfMin.execute(scanner, fromCommandLine);
                break;
            case "remove_lower":
                RemoveLower.execute(scanner, fromCommandLine);
                break;
            case "history":
                History.execute(scanner);
                break;
            case "min_by_weapon_type":
                MinByWeaponType.execute(scanner);
                break;
            case "group_counting_by_impact_speed":
                GroupSpeed.execute(scanner);
                break;
            case "count_greater_than_mood":
                CountMood.execute(elements[1], scanner);
                break;
            case "exit":
                Exit.execute();
                break;
            case "":
                break;
            default:
                System.out.println("Неизвестная команда");
                break;
        }
    }
}
