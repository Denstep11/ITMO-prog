package util;

import data.*;
import exeptions.CoordinatesXException;
import exeptions.CoordinatesYException;
import exeptions.NullExeption;
import exeptions.SpeedExeption;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Scanner;

/**
 * creates a new collection item
 */
public class CreationElement {
    /**
     * create new element for collection
     * @param id new id element
     * @param in input stream
     * @param fromCommandLine information about input stream
     * @return humanBeing element for collection
     */
    public static HumanBeing create(Long id, Scanner in, Boolean fromCommandLine) {
        HumanBeing humanBeing = new HumanBeing();
        Boolean streamflag = fromCommandLine;
        humanBeing.setId(id);
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
        zonedDateTime = zonedDateTime.minusWeeks((long) (Math.random() * 100));
        zonedDateTime = zonedDateTime.minusMinutes((long) (Math.random() * 100));
        zonedDateTime = zonedDateTime.minusDays((long) (Math.random() * 100));

        Coordinates coordinates = new Coordinates();

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите имя:");
                }
                humanBeing.setName(in.nextLine());
                if (Objects.equals(humanBeing.getName(), "")) {
                    throw new NullExeption();
                }
                streamflag = false;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (streamflag);
        streamflag = fromCommandLine;

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите координату x:");
                }
                coordinates.setX(Double.valueOf(in.nextLine()));
                if (coordinates.getX() > 710) {
                    throw new CoordinatesXException();
                }
                streamflag = false;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (streamflag);
        streamflag = fromCommandLine;

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите координату y:");
                }
                coordinates.setY(Float.parseFloat(in.nextLine()));
                if (coordinates.getY() > 197) {
                    throw new CoordinatesYException();
                }
                streamflag = false;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (streamflag);
        streamflag = fromCommandLine;

        humanBeing.setCoordinates(coordinates);
        humanBeing.setCreationDate(zonedDateTime);

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите realHero(true/false):");
                }
                humanBeing.setRealHero(Boolean.valueOf(in.nextLine()));
                streamflag = false;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (streamflag);
        streamflag = fromCommandLine;

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите hasToothpick(true/false):");
                }
                humanBeing.setHasToothpick(Boolean.valueOf(in.nextLine()));
                streamflag = false;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (streamflag);
        streamflag = fromCommandLine;

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите скорость(<=809):");
                }
                humanBeing.setImpactSpeed(Double.parseDouble(in.nextLine()));
                if (humanBeing.getImpactSpeed() > 809) {
                    throw new SpeedExeption();
                }
                streamflag = false;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (streamflag);
        streamflag = fromCommandLine;

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите WeaponType(AXE, PISTOL, SHOTGUN, RIFLE):");
                }
                String arg = in.nextLine();
                if (!Objects.equals(arg, "")) {
                    humanBeing.setWeaponType(WeaponType.valueOf(arg));
                }
                streamflag = false;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (streamflag);
        streamflag = fromCommandLine;

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите Mood(SADNESS, LONGING, GLOOM, FRENZY):");
                }
                String arg = in.nextLine();
                if (!Objects.equals(arg, "")) {
                    humanBeing.setMood(Mood.valueOf(arg));
                }
                streamflag = false;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (streamflag);
        streamflag = fromCommandLine;

        Car car = new Car();

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите cool car(true/false):");
                }
                String arg = in.nextLine();
                if (!Objects.equals(arg, "")) {
                    car.setCool(Boolean.valueOf(arg));
                    humanBeing.setCar(car);
                }
                else{
                    car=null;
                }
                streamflag = false;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (streamflag);
        return humanBeing;
    }
}
