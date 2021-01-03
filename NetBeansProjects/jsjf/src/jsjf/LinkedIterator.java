package jsjf;

import java.util.*;

/**
 *
 * @author Hagen
 */
public class LinkedIterator<T> implements Iterator<T> {

  private DoubleNode<T> current;
  private int count; //Elementos del conjunto

  public LinkedIterator(DoubleNode<T> current, int count) {
    this.current = current;
    this.count = count;
  }

  public boolean hasNext() {
    return count > 0;
  }

  public T next() throws NoSuchElementException {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    T resultado = current.getElemento();
    current = current.getNext();
    count--;
    return resultado;
  }

}
