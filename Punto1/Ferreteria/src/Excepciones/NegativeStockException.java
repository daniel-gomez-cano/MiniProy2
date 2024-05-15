package Excepciones;

public class NegativeStockException extends Exception{
    public NegativeStockException(String message){
        super(message);
    }
}
