package exeptions;

/**
 * Null in variables exception
 */
public class NullExeption extends Exception{
    public NullExeption(){
        System.out.println("Ошибка! Значение не может быть пустым!");
    }
}
