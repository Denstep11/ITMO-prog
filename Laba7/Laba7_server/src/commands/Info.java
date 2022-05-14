package commands;

import network.Server;
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
     */
    public static String execute() {
        String answer;
        History.archive.add(name);
        answer = "Информация о коллекции:" + "\n" + "Тип хранящихся данных в коллекции: HumanBeing" + "\n"
                + "Значением для сортировки выступает поле id" + "\n" + "Время создания коллекции:" + Collection.createtime
                + "\n" + "Время изменения коллекции:" + Collection.modiftime + "\n" +
                "Количество элементов: " + Collection.tree.size();
        return answer;
    }
}
