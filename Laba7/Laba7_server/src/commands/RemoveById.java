package commands;

import data.HumanBeing;
import network.Server;
import util.Collection;
import util.ComandInterface;
import util.Updatedb;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

/**
 * remove element by id in collection
 */
public class RemoveById implements ComandInterface {
    private final static String name = "remove_by_id";

    /**
     * executes the command
     * @param id id element for remove
     */
    public static String execute(String id, String login) {
        String answer="";
        int bd=0;
        History.archive.add(name);
        Updatedb.lk.writeLock().lock();
        for (HumanBeing set : Collection.tree) {
            if (set.getId().equals(Long.valueOf(id))) {
                PreparedStatement ps;
                try {
                    ps = Updatedb.conn.prepareStatement("DELETE FROM humans\n" +
                            "WHERE id = ? and (SELECT access_human.login FROM access_human WHERE id=?)='"+login+"';");
                    ps.setInt(1, Integer.parseInt(id));
                    ps.setInt(2, Integer.parseInt(id));
                    bd = ps.executeUpdate();
                    ps = Updatedb.conn.prepareStatement("DELETE FROM access_human\n" +
                            "WHERE id = ? and login='"+login+"';");
                    ps.setInt(1, Integer.parseInt(id));
                    bd = ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                    answer = "повторите запарос";
                }
            }else {
                answer = "Элемент с этим id не найден";
            }
        }
        Updatedb.lk.writeLock().unlock();
        if(bd>0){
            if (Collection.tree.removeIf(element -> element.getId() == Long.valueOf(id))) {
                Date date = new Date();
                Collection.modiftime = date.toString();
                answer = "Элемент с id:=" + id + " удален";
            } else {
                answer = "Элемент с этим id не найден";
            }
        }
        return answer;
    }
}
