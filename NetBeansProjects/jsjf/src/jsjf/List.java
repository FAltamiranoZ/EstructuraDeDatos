package jsjf;

/**
 *
 * @author Hagen
 */
public interface List<T> extends LinearCollectionIterable<T> {
  T first();
  T last();
  T removeFirst();
  T removeLast();
}
