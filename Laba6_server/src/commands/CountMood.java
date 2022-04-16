package commands;

import data.HumanBeing;
import data.Mood;
import network.Server;
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
     *
     * @param mood Mood for comparisons
     */
    public static void execute(String mood) {
        History.archive.add(name);
        int counter = 0;
        counter = (int) Collection.tree.stream().filter((s)-> s.getMood()!=null).filter((s)-> s.getMood().ordinal()>Mood.valueOf(mood).ordinal()).count();
        Server.answer = String.valueOf(counter);
    }
}
