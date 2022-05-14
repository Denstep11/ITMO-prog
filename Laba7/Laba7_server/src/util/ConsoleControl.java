package util;

import commands.*;
import network.SerializationCommands;

import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * selects the command to be executed
 */
public class ConsoleControl {
    public String answer;
    /**
     * choice command
     * @param s command string(name)
     */
    public String choice(String s, SerializationCommands serializationCommands) {
        String[] elements = s.split(" ");
        switch (elements[0]) {
            case "help":
                answer = Help.execute();
                break;
            case "info":
                answer = Info.execute();
                break;
            case "show":
                answer =  Show.execute();
                break;
            case "add":
                answer = Add.execute(serializationCommands.getHuman(), serializationCommands.getLogin());
                break;
            case "update":
                answer =  UpdateId.execute(elements[1], serializationCommands.getHuman(),serializationCommands.getLogin());
                break;
            case "remove_by_id":
                answer =  RemoveById.execute(elements[1],serializationCommands.getLogin());
                break;
            case "clear":
                try {
                    answer =  Clear.execute(serializationCommands.getLogin());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "execute_script":
                ExecuteScript.execute();
                break;
            case "save":
                Save.execute();
                break;
            case "add_if_min":
                answer = AddIfMin.execute(serializationCommands.getHuman(),serializationCommands.getLogin());
                break;
            case "remove_lower":
                answer = RemoveLower.execute(serializationCommands.getHuman(),serializationCommands.getLogin());
                break;
            case "history":
                answer = History.execute();
                break;
            case "min_by_weapon_type":
                answer =  MinByWeaponType.execute();
                break;
            case "group_counting_by_impact_speed":
                answer = GroupSpeed.execute();
                break;
            case "count_greater_than_mood":
                answer = CountMood.execute(elements[1]);
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
        return answer;
    }
}
