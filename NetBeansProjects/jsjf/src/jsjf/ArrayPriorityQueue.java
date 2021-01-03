package jsjf;

import jsjf.exceptions.EmptyCollectionException;

/**
 *
 * @author Hagen
 */
public class ArrayPriorityQueue<T> extends ArrayQueue<T> {

  public void enqueue(T elemento) {
    super.add(elemento);
    siftUp(next - 1);
  }

  public T dequeue() {
    if (isEmpty()) {
      throw new EmptyCollectionException("PriorityQueue");
    }
    T res = (T) collection[0];
    collection[0] = collection[next - 1];
    next--;
    collection[next] = null;
    siftDown(0);
    return res;
  }

  public void siftUp(int i) {
    int padre = (i - 1) / 2;
    if (i > 0 && mayorQue(collection[i], collection[padre])) {
      swap(i, padre);
      siftUp(padre);
    }
  }

  public void siftDown(int i) {
    int hijoiz = (2 * i) + 1;
    if (i < next) {
      if (menorQue(collection[hijoiz], collection[hijoiz + 1])) {
        hijoiz = hijoiz + 1;
      }
      if (menorQue(collection[i], collection[hijoiz])) {
        swap(i, hijoiz);
        siftDown(hijoiz);
      }
    }
  }

  public void swap(int i, int j) {
    T temp;
    temp = (T) collection[i];
    collection[i] = collection[j];
    collection[j] = temp;
  }

  public boolean mayorQue(T nuevo, T viejo) { //Regresa verdadero si nuevo es mayor que viejo.
    return ((Comparable<T>) nuevo).compareTo(viejo) > 0;
  }

  public boolean menorQue(T nuevo, T viejo) {
    return ((Comparable<T>) nuevo).compareTo(viejo) < 0;
  }

}
