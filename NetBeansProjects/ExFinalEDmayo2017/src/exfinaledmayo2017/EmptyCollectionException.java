package exfinaledmayo2017;

/**
 * 
 * @author 
 */
public class EmptyCollectionException extends RuntimeException{

    public EmptyCollectionException(){
        super("Colección vacía");
    }

    public EmptyCollectionException(String mensaje){
        super(mensaje);
    }

}
