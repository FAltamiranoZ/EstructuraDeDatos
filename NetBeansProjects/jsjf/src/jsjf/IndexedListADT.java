package jsjf;

/**
 *
 * @author Hagen
 */
public interface IndexedListADT<T> extends List<T> {
  void add(int index, T elemento);
  T getIndex(int index);
  T remove(int index);
  void set(int index, T elemento);//Sobreescribo la posición.
  int indexOf(T elemento);
}
