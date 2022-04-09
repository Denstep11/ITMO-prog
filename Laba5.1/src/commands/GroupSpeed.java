package commands;

import data.HumanBeing;
import util.Collection;
import util.ComandInterface;

import java.util.Scanner;

/**
 * creat a speed groups
 */
public class GroupSpeed implements ComandInterface {
    private final static String name = "group_counting_by_impact_speed";

    /**
     * executes the command
     * @param scanner input stream
     */
    public static void execute(Scanner scanner) {
        History.archive.add(name);
        int speed[] = new int[4];
        for (HumanBeing set : Collection.tree) {
            if (set.getImpactSpeed() <= 200) {
                speed[0]++;
            }
            if (set.getImpactSpeed() <= 400 && set.getImpactSpeed() > 200) {
                speed[1]++;
            }
            if (set.getImpactSpeed() <= 600 && set.getImpactSpeed() > 400) {
                speed[2]++;
            }
            if (set.getImpactSpeed() <= 809 && set.getImpactSpeed() > 600) {
                speed[3]++;
            }
        }
        System.out.println("Количество эдементов со скоростью [0,200]: " + speed[0]);
        System.out.println("Количество эдементов со скоростью (200,400]: " + speed[1]);
        System.out.println("Количество эдементов со скоростью (400,600]: " + speed[2]);
        System.out.println("Количество эдементов со скоростью (600,809]: " + speed[3]);
    }
}
