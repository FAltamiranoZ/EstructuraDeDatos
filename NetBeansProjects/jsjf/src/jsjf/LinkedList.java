package jsjf;

import java.util.Iterator;
import jsjf.exceptions.ElementNotFoundException;
import jsjf.exceptions.EmptyCollectionException;

/**
 * Uso de nodos centinelas.
 * @author Hagen
 */
public class LinkedList<T> {
  DoubleNode<T> head, tail;
  int count;
  
  public LinkedList(){
    clear();
  }
  
  public void clear(){
    count=0;
    DoubleNode<T> head=new DoubleNode<>();
    DoubleNode<T> tail=new DoubleNode<>();
    head.setNext(tail);
    tail.setPrev(head);
  }
  
  public int size(){
    return count;
  }
  
  public boolean isEmpty(){
    return count==0;
  }
  
  public Iterator<T> iterator(){
    return new LinkedIterator(head.getNext(), count);
  }
  
  public String toStringI(){
      if(isEmpty())
          return "";
      else
          return toStringI(this.iterator());
  }
  
  public String toStringI(Iterator<T> it){
      if(!it.hasNext())
          return "";
      else
          return toStringI(it) + it.next();
  }
  
  public String toString2(){
      if(isEmpty())
          return "";
      else{
          StringBuilder sb = new StringBuilder();
          return toString2(head.getNext(), sb);
      }
  }
  
  public String toString2(DoubleNode<T> current, StringBuilder sb){
      if(current.equals(tail))
          return sb.toString();
      else{
          sb.append(current.getElemento());
          return toString2(current.getNext(), sb);
      }
  }
  
  protected DoubleNode<T> find (T element){
      if(isEmpty())
          return null;
      else
          return find(element, head.getNext());
  }
  
  protected DoubleNode<T> find(T element, DoubleNode<T> current){
      if(current.equals(null))
          return null;
      if(current.getElemento().equals(element))
          return current;
      else
          return find(element, current.getNext());
  }
  
  public boolean contains(T element){
      return find(element) != null;
  }
  
  public T first(){
      if(isEmpty())
          throw new EmptyCollectionException("List");
      return head.getNext().getElemento();
  }
  
  public T last(){
      if(isEmpty())
          throw new EmptyCollectionException("List");
      return tail.getPrev().getElemento();
  }
  
  protected T delete(DoubleNode<T> nodo){
      nodo.getNext().setPrev(nodo.getPrev());
      nodo.getPrev().setNext(nodo.getNext());
      count--;
      return nodo.getElemento();
  }
  
  public T removeFirst() throws EmptyCollectionException{
      if(isEmpty())
          throw new EmptyCollectionException("List");
      return delete(head.getNext());
  }
  
  public T removeLast() throws EmptyCollectionException{
    if(isEmpty())
        throw new EmptyCollectionException("List");
    return delete(tail.getPrev());
  }
  
  public T remove(T element) throws EmptyCollectionException, ElementNotFoundException{
    if(isEmpty())
        throw new EmptyCollectionException("List");  
    if(find(element) == null)
        throw new ElementNotFoundException((String) element);
    return delete(find(element));
  }
  
  protected void insert(T element, DoubleNode<T> anterior, DoubleNode<T> siguiente){
      DoubleNode<T> nuevo = new DoubleNode(element);
      anterior.setNext(nuevo);
      siguiente.setPrev(nuevo);
      nuevo.setPrev(anterior);
      nuevo.setNext(siguiente);
      count++;
  }
  
  public void add (T element){
      if(isEmpty()){
          insert(element,head,tail);
      }else{
        insert(element, tail.getPrev(), tail);
      }
  }
  
  private int cuentaR(){
      if(isEmpty())
          return 0;
      else 
          return cuentaR(head.getNext());
  }
  
  private int cuentaR(DoubleNode<T> current){
      if(current.equals(tail))
          return 0;
      if(current.getElemento().equals(null))
          return 0 + cuentaR(current.getNext());
      else
          return 1 + cuentaR(current.getNext());
  }
  
  private int removeAll(){
      if(isEmpty())
          return 0;
      else 
          return removeAll(tail.getPrev());
  }
  
  private int removeAll(DoubleNode<T> current){
      if(current == head)
          return 0;
      else{
          delete(current);
          return 1 + removeAll(current.getPrev());
      }
  }
}
