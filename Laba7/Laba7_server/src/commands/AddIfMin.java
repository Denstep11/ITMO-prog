package commands;

import data.*;
import util.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;


/**
 * add an element if this min element
 */
public class AddIfMin implements ComandInterface {
    private final static String name = "add_if_min";

    /**
     * executes the command
     */
    public static String execute(HumanBeing humanBeing, String login) {
        String answer;
        History.archive.add(name);
        ValueGeneration.generation(humanBeing);
        boolean minspeed = true;
        Updatedb.lk.readLock().lock();
        for (HumanBeing set : Collection.tree) {
            if (humanBeing.getImpactSpeed() >= set.getImpactSpeed()) {
                minspeed = false;
                break;
            }
        }
        Updatedb.lk.readLock().unlock();
        if (minspeed) {
            PreparedStatement ps;
            Updatedb.lk.writeLock().lock();
            try {
                ps = Updatedb.conn.prepareStatement("INSERT INTO humans VALUES (nextval('serial'),?,?,?,?,?,?,?,?,?);\n" +
                        "INSERT INTO access_human VALUES (currval('serial'),'"+login+"');");
                ps.setString(1, humanBeing.getName());
                ps.setDouble(2,humanBeing.getCoordinates().getX());
                ps.setFloat(3,humanBeing.getCoordinates().getY());
                ps.setString(4, String.valueOf(humanBeing.getRealHero()));
                ps.setString(5, String.valueOf(humanBeing.getHasToothpick()));
                ps.setDouble(6,humanBeing.getImpactSpeed());
                ps.setString(7, String.valueOf(humanBeing.getWeaponType()));
                ps.setString(8, String.valueOf(humanBeing.getMood()));
                ps.setString(9, String.valueOf(humanBeing.getCar()));
                int bd = ps.executeUpdate();
                if(bd>0){
                    humanBeing.setId(++Collection.id);
                    Collection.tree.add(humanBeing);
                    Date date = new Date();
                    Collection.modiftime = date.toString();
                    answer = "Элемент добавлен и имеет id:=" + humanBeing.getId();
                }
                else{
                    answer = "Потворите запрос";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                answer="Ошибка бд";
            }
            finally {
                Updatedb.lk.writeLock().unlock();
            }
            Date date = new Date();
            Collection.modiftime = date.toString();
            answer = "В коллекцию дабавлен новый элемент";
        } else {
            answer = "Значение элемента больше, чем у наименьшего элемента коллекции!";
        }
        return answer;
    }
}
