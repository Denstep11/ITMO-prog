package commands;

import data.*;
import network.Server;
import util.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * adds an element
 */

public class Add implements ComandInterface {
    private final static String name = "add";

    /**
     * executes the command
     */
    public static String execute(HumanBeing human, String login){
        String answer;
        History.archive.add(name);
        ValueGeneration.generation(human);
        PreparedStatement ps;
        Updatedb.lk.writeLock().lock();
        try {
            ps = Updatedb.conn.prepareStatement("INSERT INTO humans VALUES (nextval('serial'),?,?,?,?,?,?,?,?,?);\n" +
                    "INSERT INTO access_human VALUES (currval('serial'),'"+login+"');");
            ps.setString(1, human.getName());
            ps.setDouble(2,human.getCoordinates().getX());
            ps.setFloat(3,human.getCoordinates().getY());
            ps.setString(4, String.valueOf(human.getRealHero()));
            ps.setString(5, String.valueOf(human.getHasToothpick()));
            ps.setDouble(6,human.getImpactSpeed());
            ps.setString(7, String.valueOf(human.getWeaponType()));
            ps.setString(8, String.valueOf(human.getMood()));
            ps.setString(9, String.valueOf(human.getCar()));
            int bd = ps.executeUpdate();
            if(bd>0){
                human.setId(++Collection.id);
                Collection.tree.add(human);
                Date date = new Date();
                Collection.modiftime = date.toString();
                answer = "Элемент добавлен и имеет id:=" + human.getId();
            }
            else{
                answer = "Потворите запрос";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ошибка бд");
            answer="Ошибка бд";
        }
        finally {
            Updatedb.lk.writeLock().unlock();
        }
        return answer;
    }
}
