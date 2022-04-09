package commands;

import data.*;
import util.Collection;
import util.CollectionControl;
import util.ComandInterface;
import util.CreationElement;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * remove elements if than this element
 */
public class RemoveLower implements ComandInterface {
    private final static String name = "remove_lower";

    /**
     * executes the command
     * @param scanner input stream
     * @param fromCommandLine information about input stream
     */
    public static void execute(Scanner scanner, Boolean fromCommandLine) {
        History.archive.add(name);
        HumanBeing humanBeing = new HumanBeing();
        humanBeing = CreationElement.create(++CollectionControl.id, scanner, fromCommandLine);

        ArrayList<HumanBeing> locallist = new ArrayList<>();
        for (HumanBeing set : Collection.tree) {
            if (set.getImpactSpeed() < humanBeing.getImpactSpeed()) {
                locallist.add(set);
            }
        }
        for (HumanBeing removeList : locallist) {
            Collection.tree.remove(removeList);
        }
        System.out.println("Элементы меньше заданного удалены");
    }
}
