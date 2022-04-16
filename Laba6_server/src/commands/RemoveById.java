package commands;

import network.Server;
import util.Collection;
import util.ComandInterface;

import java.util.Date;
import java.util.Scanner;

/**
 * remove element by id in collection
 */
public class RemoveById implements ComandInterface {
    private final static String name = "remove_by_id";

    /**
     * executes the command
     * @param id id element for remove
     */
    public static void execute(String id) {
        History.archive.add(name);
        if (Collection.tree.removeIf(element -> element.getId() == Long.valueOf(id))) {
            Date date = new Date();
            Collection.modiftime = date.toString();
            Server.answer = "Элемент с id:=" + id + " удален";
        } else {
            Server.answer = "Элемент с этим id не найден";
        }
    }
}
