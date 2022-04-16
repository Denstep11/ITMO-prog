package util;

import commands.*;
import network.SerializationCommands;

/**
 * selects the command to be executed
 */
public class ConsoleControl {
    /**
     * choice command
     * @param s command string(name)
     */
    public void choice(String s, SerializationCommands serializationCommands) {
        String[] elements = s.split(" ");
        switch (elements[0]) {
            case "help":
                Help.execute();
                break;
            case "info":
                Info.execute();
                break;
            case "show":
                Show.execute();
                break;
            case "add":
                Add.execute(serializationCommands.getHuman());
                break;
            case "update":
                UpdateId.execute(elements[1], serializationCommands.getHuman());
                break;
            case "remove_by_id":
                RemoveById.execute(elements[1]);
                break;
            case "clear":
                Clear.execute();
                break;
            case "execute_script":
                ExecuteScript.execute();
                break;
            case "save":
                Save.execute();
                break;
            case "add_if_min":
                AddIfMin.execute(serializationCommands.getHuman());
                break;
            case "remove_lower":
                RemoveLower.execute(serializationCommands.getHuman());
                break;
            case "history":
                History.execute();
                break;
            case "min_by_weapon_type":
                MinByWeaponType.execute();
                break;
            case "group_counting_by_impact_speed":
                GroupSpeed.execute();
                break;
            case "count_greater_than_mood":
                CountMood.execute(elements[1]);
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
