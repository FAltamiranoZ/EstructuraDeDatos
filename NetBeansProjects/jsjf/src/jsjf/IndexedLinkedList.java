package jsjf;

import jsjf.exceptions.*;

/**
 *
 * @author Hagen
 */
public class IndexedLinkedList<T> extends LinkedList<T> implements IndexedListADT<T> {
  
  /**
   *
   * @param index
   * @param elemento
   * @throws IndexOutOfBoundsException
   */
  @Override
  public void add(int index, T elemento) throws IndexOutOfBoundsException {
    if(index<0 || index>count)
      throw new IndexOutOfBoundsException();
    add(index, elemento, head.getNext(), 0);
  }
  
  private void add(int index, T elemento, DoubleNode<T> current, int i) {
    if (i==index)
      insert(elemento, current, current.getNext());
    else
      add(index-1,elemento, current.getNext(), i+1);
  }

  @Override
  public T getIndex(int index) throws IndexOutOfBoundsException{
    if(index>count)
      throw new IndexOutOfBoundsException("Indexed List");
    return getIndex(index, head.getNext());
  }

  private T getIndex(int index, DoubleNode<T> current) {
    if(index==0)
      return current.getElemento();
    return getIndex(index-1, current.getNext());
  }
  
  @Override
  public T remove(int index) {
    if(index>count)
      throw new IndexOutOfBoundsException("Indexed List");
    return remove(index, head.getNext());
  }

  private T remove(int index, DoubleNode<T> current) {
    if(index==0)
      return delete(current);
    return remove(index-1, current.getNext());
  }
  
  public void set(int index, T elemento) throws IndexOutOfBoundsException{
    if(index>count)
      throw new IndexOutOfBoundsException("Indexed List");
    set(index,elemento,head.getNext());
  }
  
  private void set(int index, T elemento, DoubleNode<T> current){
    if(index==0)
        current.setElemento(elemento);
    else
        set(index-1,elemento,current.getNext());
  }

  @Override
  public int indexOf(T elemento) throws ElementNotFoundException{
    return indexOf(elemento, head.getNext(),0);
  }

    private int indexOf(T elemento, DoubleNode<T> current, int index)
            throws ElementNotFoundException{
        if(index==count)
            throw new ElementNotFoundException("Indexed List");
        if(current.getElemento().equals(elemento))
            return index;
        return indexOf(elemento,current.getNext(),index+1);
    }  
    
    public T remove() {
       return removeLast();
    }
}
