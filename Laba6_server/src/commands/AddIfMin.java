package commands;

import data.*;
import network.Server;
import util.*;

import java.util.Date;
import java.util.Scanner;

/**
 * add an element if this min element
 */
public class AddIfMin implements ComandInterface {
    private final static String name = "add_if_min";

    /**
     * executes the command
     */
    public static void execute(HumanBeing humanBeing) {
        History.archive.add(name);
        ValueGeneration.generation(humanBeing);
        boolean minspeed = true;
        for (HumanBeing set : Collection.tree) {
            if (humanBeing.getImpactSpeed() >= set.getImpactSpeed()) minspeed = false;
        }
        if (minspeed) {
            Collection.tree.add(humanBeing);
            Date date = new Date();
            Collection.modiftime = date.toString();
            Server.answer = "В коллекцию дабавлен новый элемент";
        } else {
            Server.answer = "Значение элемента больше, чем у наименьшего элемента коллекции!";
        }

    }
}
