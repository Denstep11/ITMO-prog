package commands;

import data.*;
import exeptions.CoordinatesXException;
import exeptions.CoordinatesYException;
import exeptions.NullExeption;
import exeptions.SpeedExeption;
import util.Collection;
import util.CollectionControl;
import util.ComandInterface;
import util.CreationElement;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

/**
 * update element by id
 */
public class UpdateId implements ComandInterface {
    private final static String name = "update";

    /**
     * executes the command
     * @param id element id for update
     * @param scanner input stream
     * @param fromCommandLine information about input stream
     */
    public static void execute(String id, Scanner scanner, Boolean fromCommandLine) {
        History.archive.add(name);
        boolean find = false;
        HumanBeing removeset = new HumanBeing();
        HumanBeing humanBeing = new HumanBeing();

        for (HumanBeing set : Collection.tree) {
            if (set.getId() == Long.valueOf(id)) {
                humanBeing.setId(Long.valueOf(id));
                find = true;
                removeset = set;
                humanBeing = CreationElement.create(Long.valueOf(id), scanner, fromCommandLine);
            }
        }
        if (find) {
            Collection.tree.remove(removeset);
            Collection.tree.add(humanBeing);
            Date date = new Date();
            Collection.modiftime = date.toString();
            System.out.println("Значение элемента id:=" + id + " обновлено");
        } else {
            System.out.println("Элемент с этим id не найден");
        }
    }
}
