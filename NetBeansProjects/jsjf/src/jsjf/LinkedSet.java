package jsjf;

import java.util.Iterator;
import java.util.Random;
import jsjf.exceptions.ElementNotFoundException;
import jsjf.exceptions.EmptyCollectionException;

/**
 *
 * @author edi
 * @param <T>
 */
public class LinkedSet<T> implements SetADT<T> {
    private int count;
    private DoubleNode<T> head, tail;
    private static final Random R = new Random();

    public LinkedSet() {
        clear();
    }
    
    @Override
    public void clear(){
        count = 0;
        head = null;
        tail = null;
    }
    
    @Override
    public boolean isEmpty(){
      return count==0; //Head==Null;
    }
    
    @Override
    public Iterator<T> iterator(){
        return new LinkedIterator(head, count);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = this.iterator();
        while(it.hasNext()){
            sb.append(it.next()).append("\n");
        }
        return sb.toString();
    }
    
    @Override
    public boolean equals(SetADT<T> otro){
        boolean res = true;
        if(count == otro.size()){
            Iterator<T> it = this.iterator(); 
            while(it.hasNext() && res){
                if(!otro.contains(it.next()))
                    res = false;
            }
        }else{
            res = false;
        }
        return res;
    }
    
    public boolean equalsR(SetADT<T> otro){
        if(count != otro.size()){
            return false;
        }else{
            return equalsR(otro, this.iterator());
        }
    }
    
    public boolean equalsR(SetADT<T> otro, Iterator<T> it){
        if(!it.hasNext())
            return true;
        else
            if(!otro.contains(it.next()))
                return false;
            else
                return equalsR(otro,it);
    }
    
    public boolean equalsR2(SetADT<T> otro){
        if(count != otro.size()){
            return false;
        }else{
            return equalsR2(otro, head);
        }
    }
    
    public boolean equalsR2(SetADT<T> otro, DoubleNode<T> current){
        if(current.getElemento() == null){
            return true;
        }else{
            if(!otro.contains(current.getElemento()))
                return false;
            else
                return equalsR2(otro,current.getNext());
        }
    }
    
    @Override
    public int size(){
        return count;
    }
    
    private DoubleNode<T> find(T element){
      DoubleNode<T> current=head;
      
      return find(element, head);
    }
    
    public DoubleNode<T> find(T elemento, DoubleNode<T> current){
      if(current==null){
        return null;
      }
      if(current.getElemento().equals(elemento)){
        return current;
      }
      return find(elemento, current.getNext());
    }
    
    @Override
    public boolean contains(T elemento){
      return find(elemento)!=null;
    }
    
    @Override
    public T remove(T target)throws EmptyCollectionException, ElementNotFoundException{
      if(this.isEmpty()){
        throw new EmptyCollectionException("Linked set");
      }
      DoubleNode<T> current = find(target);
      if(find(target)==null){
        throw new ElementNotFoundException("Linked set");
      }
      T resultado=current.getElemento();
      return delete(current);
    }    
    
    private T delete(DoubleNode<T> current){
      T resultado=current.getElemento();
      count--;
      if(isEmpty()){
        clear();
      }
      else if(current==head){
        head=head.getNext();
        head.setPrev(null);
      }
      else if(current==tail){
        tail=tail.getPrev();
        tail.setNext(null);
      }
      else{
        /*DoubleNode<T>siguiente=current.getNext(); //versión entendible
        DoubleNode<T>anterior=current.getPrev();
        siguiente.setPrev(anterior);
        anterior.setNext(siguiente);
*/
        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
      }
      return resultado;
    }
    
    public T remove() throws EmptyCollectionException{
      if(isEmpty()){
        throw new EmptyCollectionException("Linked set");
      }
      int index=R.nextInt(count);
      DoubleNode<T> current=head;
      for(int i=0;i<index;i++){
        current=current.getNext();
      }
      return delete(current);
    }
    
    public void add (T elemento){
      if(!contains(elemento)){
      DoubleNode<T> nuevoTail= new DoubleNode<>(elemento);
      if(isEmpty()){
        head=nuevoTail;
      }
      else{
        nuevoTail.setPrev(tail);
        tail.setNext(nuevoTail);
      }
      tail=nuevoTail;
      count++;
      }
    }
    
}
