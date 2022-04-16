package util;

import data.*;
import exceptions.CoordinatesXException;
import exceptions.CoordinatesYException;
import exceptions.NullExсeption;
import exceptions.SpeedExсeption;

import java.util.Objects;
import java.util.Scanner;

/**
 * creates a new collection item
 */
public class CreationElement {
    /**
     * create new element for collection
     * @param in input stream
     * @param fromCommandLine information about input stream
     * @return humanBeing element for collection
     */
    public static HumanBeing create(Scanner in, Boolean fromCommandLine) {
        HumanBeing humanBeing = new HumanBeing();
        Coordinates coordinates = new Coordinates();

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите имя:");
                }
                humanBeing.setName(in.nextLine());
                if (Objects.equals(humanBeing.getName(), "")) {
                    throw new NullExсeption();
                }
                break;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (true);

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите координату x:");
                }
                coordinates.setX(Double.valueOf(in.nextLine()));
                if (coordinates.getX() > 710) {
                    throw new CoordinatesXException();
                }
                break;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (true);

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите координату y:");
                }
                coordinates.setY(Float.parseFloat(in.nextLine()));
                if (coordinates.getY() > 197) {
                    throw new CoordinatesYException();
                }
                break;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (true);

        humanBeing.setCoordinates(coordinates);

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите realHero(true/false):");
                }
                humanBeing.setRealHero(Boolean.valueOf(in.nextLine()));
                break;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (true);

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите hasToothpick(true/false):");
                }
                humanBeing.setHasToothpick(Boolean.valueOf(in.nextLine()));
                break;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (true);

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите скорость(<=809):");
                }
                humanBeing.setImpactSpeed(Double.parseDouble(in.nextLine()));
                if (humanBeing.getImpactSpeed() > 809) {
                    throw new SpeedExсeption();
                }
                break;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (true);

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите WeaponType(AXE, PISTOL, SHOTGUN, RIFLE):");
                }
                String arg = in.nextLine();
                if (!Objects.equals(arg, "")) {
                    humanBeing.setWeaponType(WeaponType.valueOf(arg));
                }
                break;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (true);

        do {
            try {
                if (fromCommandLine) {
                    System.out.print("Введите Mood(SADNESS, LONGING, GLOOM, FRENZY):");
                }
                String arg = in.nextLine();
                if (!Objects.equals(arg, "")) {
                    humanBeing.setMood(Mood.valueOf(arg));
                }
                break;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (true);

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
                break;
            } catch (Exception ex) {
                System.out.println("Некорректный ввод данных");
            }
        }
        while (true);
        return humanBeing;
    }
}
