package commands;


import data.Mood;
import network.Server;
import util.Collection;
import util.ComandInterface;

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
    public static String execute(String mood) {
        String answer;
        History.archive.add(name);
        int counter;
        counter = (int) Collection.tree.stream().filter((s)-> s.getMood()!=null).filter((s)-> s.getMood().ordinal()>Mood.valueOf(mood).ordinal()).count();
        answer = String.valueOf(counter);
        return answer;
    }
}
