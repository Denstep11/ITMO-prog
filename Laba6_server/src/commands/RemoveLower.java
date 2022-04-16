package commands;

import data.*;
import network.Server;
import util.*;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * remove elements if than this element
 */
public class RemoveLower implements ComandInterface {
    private final static String name = "remove_lower";

    /**
     * executes the command
     */
    public static void execute(HumanBeing humanBeing) {
        History.archive.add(name);

        ValueGeneration.generation(humanBeing);
        ArrayList<HumanBeing> locallist = new ArrayList<>();
        Collection.tree.stream().filter((s)->s.getImpactSpeed()<humanBeing.getImpactSpeed()).forEachOrdered(locallist::add);
        for (HumanBeing removeList : locallist) {
            Collection.tree.remove(removeList);
        }
        Server.answer = "Элементы меньше заданного удалены";
    }
}
