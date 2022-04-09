package commands;

import util.Collection;
import util.ComandInterface;

import java.util.Scanner;

/**
 * display info about collection
 */
public class Info implements ComandInterface {
    private final static String name = "info";

    /**
     * executes the command
     * @param scanner input stream
     */
    public static void execute(Scanner scanner) {
        History.archive.add(name);
        System.out.println("Информация о коллекции:");
        System.out.println("Тип хранящихся данных в коллекции: HumanBeing");
        System.out.println("Значением для сортировки выступает поле id");
        System.out.println("Время создания коллекции:" + Collection.createtime);
        System.out.println("Время изменения коллекции:" + Collection.modiftime);
        System.out.println("Количество элементов: " + Collection.tree.size());
    }
}
