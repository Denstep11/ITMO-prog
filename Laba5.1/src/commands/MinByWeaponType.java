package commands;

import data.HumanBeing;
import util.Collection;
import util.ComandInterface;

import java.util.Scanner;

/**
 * display minimal weapon type in collection
 */
public class MinByWeaponType implements ComandInterface {
    private final static String name = "min_by_weapon_type";

    /**
     * executes the command
     * @param scanner input stream
     */
    public static void execute(Scanner scanner) {
        History.archive.add(name);
        int minweapon = 3;
        HumanBeing m = new HumanBeing();
        if (Collection.tree.size() != 0) {
            for (HumanBeing set : Collection.tree) {
                if (set.getMood() != null) {
                    if (set.getWeaponType().ordinal() <= minweapon) {
                        minweapon = set.getWeaponType().ordinal();
                        m = set;
                    }
                }
            }
            System.out.println(m);
        }
    }
}
