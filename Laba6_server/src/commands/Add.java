package commands;

import data.*;
import network.Server;
import util.*;

import java.util.Date;

/**
 * adds an element
 */

public class Add implements ComandInterface {
    private final static String name = "add";

    /**
     * executes the command
     */
    public static void execute(HumanBeing human) {
        History.archive.add(name);
        ValueGeneration.generation(human);
        Collection.tree.add(human);
        Date date = new Date();
        Collection.modiftime = date.toString();
        Server.answer = "Элемент добавлен и имеет id:=" + human.getId();
    }
}
