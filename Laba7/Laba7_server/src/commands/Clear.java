package commands;

import data.HumanBeing;
import network.Server;
import util.Collection;
import util.ComandInterface;
import util.Updatedb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/**
 * clear collection
 */
public class Clear implements ComandInterface {
    private final static String name = "clear";

    /**
     * executes the command
     */
    public static String execute(String login) throws SQLException {
        String answer;
        int bd=0;
        History.archive.add(name);
        ResultSet res = Updatedb.statement.executeQuery("SELECT * FROM humans\n" +
                "WHERE id IN (SELECT access_human.id FROM access_human WHERE access_human.login='"+login+"');");
        Updatedb.lk.writeLock().lock();
        while (res.next()){
            int id = res.getInt(1);
            for (HumanBeing set : Collection.tree) {
                if (set.getId().equals(Long.valueOf(id))) {
                    PreparedStatement ps;
                    try {
                        ps = Updatedb.conn.prepareStatement("DELETE FROM humans\n" +
                                "WHERE id = ? and (SELECT access_human.login FROM access_human WHERE id=?)='"+login+"';");
                        ps.setInt(1, id);
                        ps.setInt(2, id);
                        bd = ps.executeUpdate();
                        ps = Updatedb.conn.prepareStatement("DELETE FROM access_human\n" +
                                "WHERE id = ? and login='"+login+"';");
                        ps.setInt(1, id);
                        bd = ps.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        answer = "повторите запарос";
                    }
                }
            }
            if(bd>0){
                if (Collection.tree.removeIf(element -> element.getId() == Long.valueOf(id))) {
                    Date date = new Date();
                    Collection.modiftime = date.toString();
                } else {
                    answer = "Элемент с этим id не найден";
                }
            }
        }
        Updatedb.lk.writeLock().unlock();
        answer = "Коллекция очищена";
        return answer;
    }
}
