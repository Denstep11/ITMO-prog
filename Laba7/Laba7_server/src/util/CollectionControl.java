package util;

import data.*;
import exсeptions.NullExсeption;
import exсeptions.SpeedExсeption;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TreeSet;

/**
 * creates a collection based on information from a file
 */
public class CollectionControl {


    /**
     * do new collection
     * @return collection
     * @throws NullExсeption null in argument
     * @throws SpeedExсeption speed more 809
     */
    public TreeSet<HumanBeing> newcollection(ResultSet res) throws NullExсeption, SpeedExсeption, SQLException {


        TreeSet<HumanBeing> collection = new TreeSet<>(new CompareHuman());
        Date date = new Date();
        Collection.createtime = date.toString();
        while (res.next()){
            HumanBeing humanBeing = new HumanBeing();
            Coordinates coordinates = new Coordinates();
            Car car = new Car();

            ZoneId zoneId = ZoneId.of("Europe/Moscow");
            ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
            zonedDateTime = zonedDateTime.minusWeeks((long) (Math.random() * 100));
            zonedDateTime = zonedDateTime.minusMinutes((long) (Math.random() * 100));
            zonedDateTime = zonedDateTime.minusDays((long) (Math.random() * 100));


            humanBeing.setId(res.getLong(1));

            if (!res.getString(2).equals("")) {
                humanBeing.setName(res.getString(2));
            } else {
                throw new NullExсeption();
            }

            humanBeing.setCreationDate(zonedDateTime);

            if (!res.getString(3).equals("")) {
                coordinates.setX(Double.valueOf(res.getString(3)));
            } else {
                throw new NullExсeption();
            }

            if (!res.getString(4).equals("")) {
                coordinates.setY(Float.valueOf(res.getString(4)));
            } else {
                throw new NullExсeption();
            }
            humanBeing.setCoordinates(coordinates);


            if (!res.getString(5).equals("")) {
                humanBeing.setRealHero(Boolean.valueOf(res.getString(5)));
            } else {
                throw new NullExсeption();
            }

            if (!res.getString(6).equals("")) {
                humanBeing.setHasToothpick(Boolean.valueOf(res.getString(6)));
            } else {
                throw new NullExсeption();
            }

            if (!res.getString(7).equals("") && Double.valueOf(res.getString(7)) <= 809) {
                humanBeing.setImpactSpeed(Double.valueOf(res.getString(7)));
            } else if (!res.getString(7).equals("") && Double.valueOf(res.getString(7)) > 809) {
                throw new SpeedExсeption();
            } else {
                throw new NullExсeption();
            }

            if (!res.getString(8).equals("null")) {
                humanBeing.setWeaponType(WeaponType.valueOf(res.getString(8)));
            }


            if (!res.getString(9).equals("null")) {
                humanBeing.setMood(Mood.valueOf(res.getString(9)));
            }


            if (!res.getString(10).equals("null")) {
                car.setCool(Boolean.valueOf(res.getString(10)));
                humanBeing.setCar(car);
            }
            else{
                car=null;
                humanBeing.setCar(car);
            }

            collection.add(humanBeing);
        }

        return collection;
    }

}
