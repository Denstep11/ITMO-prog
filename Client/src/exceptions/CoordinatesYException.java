package exceptions;
/**
 * Y coordinate exeption
 */
public class CoordinatesYException extends Exception{
    public CoordinatesYException(){
        System.out.println("Ошибка! Координата Y<=197!");
    }
}
