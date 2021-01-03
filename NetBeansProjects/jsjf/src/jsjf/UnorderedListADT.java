package jsjf;

/**
 *
 * @author Hagen
 */
public interface UnorderedListADT<T> extends List<T>{
  void addFirst(T elemento);
  void addLast(T elemento);
  void addAfter(T elemento, T referencia);
  
}
