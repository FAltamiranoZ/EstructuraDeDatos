package jsjf;

import java.util.NoSuchElementException;

/**
 *
 * @author Hagen
 */
public class UnorderedLinkedList<T> extends LinkedList<T> implements UnorderedListADT<T>{
    
    public void addFirst(T element){
        DoubleNode<T> current = head.getNext();
        insert(element, current, current.getNext());
    }
    
    public void addLast(T element){
        DoubleNode<T> current = tail.getPrev();
        insert(element, current.getPrev(), current);
    }
    
    public void addAfter(T element, T reference){
        DoubleNode<T> current = find(reference);
        insert(element, current, current.getNext());
    }
    
    public void addAfterR(T element, T reference){
        if(!isEmpty())
            addAfterR(element, reference, head.getNext());
    }
    
    public void addAfterR(T element, T reference, DoubleNode<T> current) throws NoSuchElementException{
        if(current == tail)
            throw new NoSuchElementException((String) reference);
        if(current.getElemento().equals(reference))
            insert(element, current, current.getNext());
        addAfterR(element, reference, current.getNext());
    }
    
    public T remove() {
       return removeLast();
    }
    
}
