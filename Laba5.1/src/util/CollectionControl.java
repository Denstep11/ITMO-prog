package util;

import data.*;
import exeptions.NullExeption;
import exeptions.SpeedExeption;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Date;
import java.util.TreeSet;

/**
 * creates a collection based on information from a file
 */
public class CollectionControl {

    public static long id = 0;

    /**
     * do new collection
     * @param s array with data
     * @return collection
     * @throws NullExeption null in argument
     * @throws SpeedExeption speed more 809
     */
    public TreeSet<HumanBeing> newcollection(String[] s) throws NullExeption, SpeedExeption {

        TreeSet<HumanBeing> collection = new TreeSet<>(new CompareHuman());
        Date date = new Date();
        Collection.createtime = date.toString();

        for (int i = 0; i < s.length; i = i + 9) {
            id++;
            HumanBeing humanBeing = new HumanBeing();
            Coordinates coordinates = new Coordinates();
            Car car = new Car();

            ZoneId zoneId = ZoneId.of("Europe/Moscow");
            ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
            zonedDateTime = zonedDateTime.minusWeeks((long) (Math.random() * 100));
            zonedDateTime = zonedDateTime.minusMinutes((long) (Math.random() * 100));
            zonedDateTime = zonedDateTime.minusDays((long) (Math.random() * 100));

            humanBeing.setId(Long.valueOf(id));

            if (!s[i].equals("")) {
                humanBeing.setName(s[i]);
            } else {
                throw new NullExeption();
            }

            humanBeing.setCreationDate(zonedDateTime);

            if (!s[i + 1].equals("")) {
                coordinates.setX(Double.valueOf(s[i + 1]));
            } else {
                throw new NullExeption();
            }

            if (!s[i + 2].equals("")) {
                coordinates.setY(Float.valueOf(s[i + 2]));
            } else {
                throw new NullExeption();
            }
            humanBeing.setCoordinates(coordinates);


            if (!s[i + 3].equals("")) {
                humanBeing.setRealHero(Boolean.valueOf(s[i + 3]));
            } else {
                throw new NullExeption();
            }

            if (!s[i + 4].equals("")) {
                humanBeing.setHasToothpick(Boolean.valueOf(s[i + 4]));
            } else {
                throw new NullExeption();
            }

            if (!s[i + 5].equals("") && Double.valueOf(s[i + 5]) <= 809) {
                humanBeing.setImpactSpeed(Double.valueOf(s[i + 5]));
            } else if (!s[i + 5].equals("") && Double.valueOf(s[i + 5]) > 809) {
                throw new SpeedExeption();
            } else {
                throw new NullExeption();
            }

            if (!s[i + 6].equals("")) {
                humanBeing.setWeaponType(WeaponType.valueOf(s[i + 6]));
            }


            if (!s[i + 7].equals("")) {
                humanBeing.setMood(Mood.valueOf(s[i + 7]));
            }


            if (!s[i + 8].equals("")) {
                car.setCool(Boolean.valueOf(s[i + 8]));
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
