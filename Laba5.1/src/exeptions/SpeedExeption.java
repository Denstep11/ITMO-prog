package exeptions;

/**
 * If speed more 809 exception
 */
public class SpeedExeption extends Exception{
    public SpeedExeption(){
        System.out.println("Ошибка! Скорость должна быть <=809!");
    }
}
