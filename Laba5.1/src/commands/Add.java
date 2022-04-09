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
 * adds an element
 */

public class Add implements ComandInterface {
    private final static String name = "add";

    /**
     * executes the command
     * @param scanner input stream
     * @param fromCommandLine information about input stream
     */
    public static void execute(Scanner scanner, Boolean fromCommandLine){
        History.archive.add(name);
        HumanBeing humanBeing = new HumanBeing();
        humanBeing=CreationElement.create(++CollectionControl.id,scanner,fromCommandLine);
        Collection.tree.add(humanBeing);
        Date date = new Date();
        Collection.modiftime=date.toString();
        System.out.println("Элемент добавлен и имеет id:="+humanBeing.getId());
    }
}
