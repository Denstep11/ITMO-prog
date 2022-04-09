package commands;

import data.HumanBeing;
import data.Mood;
import util.Collection;
import util.ComandInterface;

import java.util.Scanner;

/**
 * count this mood in collection
 */
public class CountMood implements ComandInterface {
    private final static String name = "count_greater_than_mood";

    /**
     * executes the command
     * @param mood Mood for comparisons
     * @param scanner input stream
     */
    public static void execute(String mood, Scanner scanner) {
        History.archive.add(name);
        int counter = 0;
        for (HumanBeing set : Collection.tree) {
            if (set.getMood() != null) {
                if (set.getMood().ordinal() > Mood.valueOf(mood).ordinal()) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
