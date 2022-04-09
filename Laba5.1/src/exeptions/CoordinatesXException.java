package exeptions;

/**
 * X coordinate exeption
 */
public class CoordinatesXException extends Exception{
    public CoordinatesXException(){
        System.out.println("Ошибка! Координата X<=710!");
    }
}
