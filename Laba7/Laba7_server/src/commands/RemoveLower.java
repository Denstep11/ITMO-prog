package commands;

import data.*;
import network.Server;
import util.*;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * remove elements if than this element
 */
public class RemoveLower implements ComandInterface {
    private final static String name = "remove_lower";

    /**
     * executes the command
     */
    public static String execute(HumanBeing humanBeing, String login) {
        String answer;
        History.archive.add(name);

        ValueGeneration.generation(humanBeing);
        ArrayList<HumanBeing> locallist = new ArrayList<>();
        Updatedb.lk.writeLock().lock();
        Collection.tree.stream().filter((s)->s.getImpactSpeed()<humanBeing.getImpactSpeed()).forEachOrdered(locallist::add);
        for (HumanBeing removeList : locallist) {
            PreparedStatement ps;
            try {
                ps = Updatedb.conn.prepareStatement("DELETE FROM humans\n" +
                        "WHERE id = ? and (SELECT access_human.login FROM access_human WHERE id=?)='"+login+"';");
                ps.setInt(1, Math.toIntExact(removeList.getId()));
                ps.setInt(2, Math.toIntExact(removeList.getId()));
                int bd = ps.executeUpdate();
                ps = Updatedb.conn.prepareStatement("DELETE FROM access_human\n" +
                        "WHERE id = ? and login='"+login+"';");
                ps.setInt(1, Math.toIntExact(removeList.getId()));
                bd = ps.executeUpdate();
                if(bd>0){
                    Collection.tree.remove(removeList);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                answer = "повторите запарос";
            }
        }
        Updatedb.lk.writeLock().unlock();
        answer = "Элементы меньше заданного удалены";
        return answer;
    }
}
