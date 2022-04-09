package commands;

import data.*;
import util.Collection;
import util.CollectionControl;
import util.ComandInterface;
import util.CreationElement;

import java.util.Date;
import java.util.Scanner;

/**
 * add an element if this min element
 */
public class AddIfMin implements ComandInterface {
    private final static String name = "add_if_min";

    /**
     * executes the command
     * @param scanner input stream
     * @param fromCommandLine information about input stream
     */
    public static void execute(Scanner scanner, Boolean fromCommandLine) {
        History.archive.add(name);
        HumanBeing humanBeing = new HumanBeing();
        humanBeing = CreationElement.create(++CollectionControl.id, scanner, fromCommandLine);

        Boolean minspeed = true;
        for (HumanBeing set : Collection.tree) {
            if (humanBeing.getImpactSpeed() >= set.getImpactSpeed()) {
                minspeed = false;
            }
        }
        if (minspeed) {
            Collection.tree.add(humanBeing);
            Date date = new Date();
            Collection.modiftime = date.toString();
            System.out.println("В коллекцию дабавлен новый элемент");
        } else {
            System.out.println("Значение элемента больше, чем у наименьшего элемента коллекции!");
        }

    }
}
