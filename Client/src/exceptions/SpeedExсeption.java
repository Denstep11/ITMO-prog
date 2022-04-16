package exceptions;

/**
 * If speed more 809 exception
 */
public class SpeedExсeption extends Exception{
    public SpeedExсeption(){
        System.out.println("Ошибка! Скорость должна быть <=809!");
    }
}
