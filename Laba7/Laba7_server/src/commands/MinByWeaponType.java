package commands;

import data.HumanBeing;
import network.Server;
import util.Collection;
import util.ComandInterface;

import java.util.Comparator;


/**
 * display minimal weapon type in collection
 */
public class MinByWeaponType implements ComandInterface {
    private final static String name = "min_by_weapon_type";

    /**
     * executes the command
     */
    public static String execute() {
        String answer;
        History.archive.add(name);
        HumanBeing man = new HumanBeing();
        if (Collection.tree.size() != 0) {
            man = Collection.tree.stream().filter((s) -> s.getWeaponType() != null).min(Comparator.comparing(HumanBeing::getWeaponType)).get();
        }
        answer = man.toString();
        return answer;
    }
}
