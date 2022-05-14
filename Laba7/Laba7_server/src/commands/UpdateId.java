package commands;

import data.*;
import network.Server;
import util.Collection;
import util.ComandInterface;
import util.Updatedb;
import util.ValueGeneration;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;


/**
 * update element by id
 */
public class UpdateId implements ComandInterface {
    private final static String name = "update";

    /**
     * executes the command
     * @param id element id for update
     */
    public static String execute(String id, HumanBeing humanBeing, String login) {
        String answer;
        History.archive.add(name);
        boolean find = false;
        HumanBeing removeset = new HumanBeing();
        ValueGeneration.generation(humanBeing);
        humanBeing.setId(Long.valueOf(id));
        for (HumanBeing set : Collection.tree) {
            if (set.getId().equals(Long.valueOf(id))) {
                find = true;
                removeset = set;
                break;
            }
        }
        if (find) {
            Updatedb.lk.writeLock().lock();
            PreparedStatement ps;
            try {
                ps = Updatedb.conn.prepareStatement("UPDATE humans\n" +
                        "SET name = ?,\n" +
                        "\tcoordinatesx = ?,\n" +
                        "\tcoordinatesy = ?,\n" +
                        "\trealhero = ?,\n" +
                        "\thastoothpick = ?,\n" +
                        "\timpactspeed = ?,\n" +
                        "\tweapontype = ?,\n" +
                        "\tmood = ?,\n" +
                        "\tcar = ?\n" +
                        "\tWHERE id = ? and (SELECT access_human.login FROM access_human WHERE id=?)='"+login+"';");
                ps.setString(1, humanBeing.getName());
                ps.setDouble(2,humanBeing.getCoordinates().getX());
                ps.setFloat(3,humanBeing.getCoordinates().getY());
                ps.setString(4, String.valueOf(humanBeing.getRealHero()));
                ps.setString(5, String.valueOf(humanBeing.getHasToothpick()));
                ps.setDouble(6,humanBeing.getImpactSpeed());
                ps.setString(7, String.valueOf(humanBeing.getWeaponType()));
                ps.setString(8, String.valueOf(humanBeing.getMood()));
                ps.setString(9, String.valueOf(humanBeing.getCar()));
                ps.setInt(10, Integer.parseInt(id));
                ps.setInt(11, Integer.parseInt(id));
                int bd = ps.executeUpdate();
                System.out.println(bd);
                if(bd>0){
                    Collection.tree.remove(removeset);
                    System.out.println(removeset);
                    Collection.tree.add(humanBeing);
                    Date date = new Date();
                    Collection.modiftime = date.toString();
                    answer = "Значение элемента id:=" + id + " обновлено";
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
        } else {
            answer = "Элемент с этим id не найден";
        }
        return answer;
    }
}
