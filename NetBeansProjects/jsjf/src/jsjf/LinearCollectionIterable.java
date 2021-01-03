package jsjf;

/**
 *
 * @author Hagen
 */
public interface LinearCollectionIterable<T> extends LinearCollection<T>, Iterable<T> {
  int size();
  boolean contains(T elemento);
  String toString();
  T remove(T elemento);
}
