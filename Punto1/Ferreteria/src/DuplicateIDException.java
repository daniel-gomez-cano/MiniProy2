//Creación de excepción para evitar ID repetidos
public class DuplicateIDException extends Exception {
    public DuplicateIDException(String message) {
        super(message);
    }
}