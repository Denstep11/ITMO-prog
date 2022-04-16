package commands;

import data.HumanBeing;
import network.Server;
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
     */
    public static void execute() {
        History.archive.add(name);
        int speed[] = new int[4];
        speed[0] = (int) Collection.tree.stream().filter((s)->s.getImpactSpeed()<=200).count();
        speed[1] = (int) Collection.tree.stream().filter((s)->s.getImpactSpeed()<=400 && s.getImpactSpeed()>200).count();
        speed[2] = (int) Collection.tree.stream().filter((s)->s.getImpactSpeed()<=600 && s.getImpactSpeed()>400).count();
        speed[3] = (int) Collection.tree.stream().filter((s)->s.getImpactSpeed()<=809 && s.getImpactSpeed()>600).count();
        Server.answer = "Количество эдементов со скоростью [0,200]: " + speed[0] +"\n"+
                "Количество эдементов со скоростью (200,400]: " + speed[1] + "\n"+
                "Количество эдементов со скоростью (400,600]: " + speed[2] + "\n"+
                "Количество эдементов со скоростью (600,809]: " + speed[3];
    }
}
