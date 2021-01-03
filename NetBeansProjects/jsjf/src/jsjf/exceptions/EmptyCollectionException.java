package jsjf.exceptions;

/**
 *Excepcion lanzada si la colección esta vacia.
 * @author Hagen
 */
public class EmptyCollectionException extends RuntimeException{

  public EmptyCollectionException(String collection) {
    super("La collection "+collection+" está vacio");
  }
  
  
}
