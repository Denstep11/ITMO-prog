package commands;

import data.*;
import network.Server;
import util.Collection;
import util.ComandInterface;
import util.ValueGeneration;

import java.util.Date;


/**
 * update element by id
 */
public class UpdateId implements ComandInterface {
    private final static String name = "update";

    /**
     * executes the command
     * @param id element id for update
     */
    public static void execute(String id, HumanBeing humanBeing) {
        History.archive.add(name);
        boolean find = false;
        HumanBeing removeset = new HumanBeing();
        ValueGeneration.generation(humanBeing);

        for (HumanBeing set : Collection.tree) {
            if (set.getId() == Long.valueOf(id)) {
                humanBeing.setId(Long.valueOf(id));
                find = true;
                removeset = set;
            }
        }
        if (find) {
            Collection.tree.remove(removeset);
            Collection.tree.add(humanBeing);
            Date date = new Date();
            Collection.modiftime = date.toString();
            Server.answer = "Значение элемента id:=" + id + " обновлено";
        } else {
            Server.answer = "Элемент с этим id не найден";
        }
    }
}
