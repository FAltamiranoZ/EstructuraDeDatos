package jsjf;
//Conjuntos, no tienen repetidos.

import java.util.Iterator;
import java.util.Random;
import jsjf.exceptions.ElementNotFoundException;
import jsjf.exceptions.EmptyCollectionException;

/**
 *
 * @author Hagen
 */
public class ArraySet<T> extends ArrayLinearCollection<T> implements SetADT<T> {

  private final int NOT_FOUND = -1;
  private static final Random r = new Random();

  public int size() {
    return super.size();
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("ArraySet \n");
    for (T elemento : this) {
      sb.append(elemento.toString()).append("\n");
    }
    return sb.toString();
  }

  public int indexOf(T elemento) {
    int i = 0, res = NOT_FOUND;
    while (i < next && res == NOT_FOUND) {
      if (collection[i].equals(elemento)) {
        res = i;
      }
      i++;
    }
    return res;
  }

  public boolean contains(T elemento) {
    return indexOf(elemento) != NOT_FOUND;
  }

  public void add(T elemento) {
    if (!contains(elemento)) {
      super.add(elemento);
    }
  }

  public T remove(T element) throws ElementNotFoundException {
    T res = null;
    int pos = indexOf(element);
    if (pos != NOT_FOUND) {
      res = collection[pos];
      collection[pos] = collection[--next];
      collection[next] = null;
    } else {
      throw new ElementNotFoundException("Set");
    }
    return res;
  }

  @Override
  public T remove() throws EmptyCollectionException {
    if (isEmpty()) {
      throw new EmptyCollectionException("Set");
    } else {
      int pos = r.nextInt(next);
      return remove(collection[pos]);
    }
  }

  @Override
  public boolean equals(SetADT<T> otro) {
    int i = 0;
    if (size() == otro.size()) {
      while (i < next && otro.contains(collection[i])) {
        i++;
      }
    }
    return i == size();
  }

  public boolean equalsRecursivo(SetADT<T> otro) {//"En recursivos hay returns como si fueran chicles" Merino 2017.
    if (size() != otro.size()) {
      return false;
    } else {
      return equalsRecursivo(otro, 0);
    }
  }

  public boolean equalsRecursivo(SetADT<T> otro, int i) {
    if (i == otro.size()) {
      return true;
    }
    if (!otro.contains(collection[i])) {
      return false;
    }
    return equalsRecursivo(otro, ++i);
  }
  
  public boolean equalsIterador(SetADT<T> otro){//Hay un solo return al final.
    boolean res=true;
    Iterator<T> it=iterator();
    if(size()==otro.size()){
      while(it.hasNext() && res){
        if(!otro.contains(it.next())){
          res=false;
        }
      }
    }
    else{
            res=false;
    }
    return res;
  }
  
  public boolean equalsIteradorRecursivo(SetADT<T>otro){
    if(size()==otro.size()){
      return false;
    }
    return equalsIteradorRecursivo(otro.iterator());
  }
  
  public boolean equalsIteradorRecursivo(Iterator<T> it){
    if(!it.hasNext()){
      return true;
    }
    if(!this.contains(it.next())){
      return false;
    }
    return equalsIteradorRecursivo(it);//Cambio en it.next (Ver código de la clase).
  }

  @Override
  public Iterator<T> iterator() {
    return new ArrayIterator(collection, next);
  }

}
