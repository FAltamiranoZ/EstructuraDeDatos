package jsjf;

/**
 *
 * @author Hagen
 * @param <T>
 */
public class OrderedLinkedList<T extends Comparable> extends LinkedList<T> implements OrderedListADT<T>{
    
    public void add(T element){
        if(isEmpty()){
            insert(element,head,tail);
        }else{
            add(element,head.getNext());
        }
    }
    
    public void add(T element, DoubleNode<T> current){
        if(current == tail){
            insert(element,current.getPrev(), current);
        }else if(element.compareTo(current.getElemento())>=0){
            insert(element,current.getPrev(), current);
        }else
            add(element,current.getNext());
    }

    @Override
    public T remove() {
       return removeLast();
    }
    
    public void removeAllGreater(T elemento){
        if(!isEmpty())
            removeAllGreater(elemento, tail.getPrev());
    }

    private void removeAllGreater(T elemento, DoubleNode<T> current) {
        if(current.getElemento().compareTo(elemento)>0){ 
                head.setNext(current.getNext());
                current.getNext().setPrev(head);
        }else{
            removeAllGreater(elemento, current.getPrev());
        }
    }
    
    public static void main(String[] args) {
        OrderedLinkedList<Integer> ejemplo = new OrderedLinkedList<>();
        ejemplo.add(1);
        ejemplo.add(2);
        ejemplo.add(3);
        ejemplo.add(4);
        ejemplo.add(5);
        ejemplo.add(6);
        ejemplo.add(7);
        ejemplo.removeAllGreater(4);
        System.out.println(ejemplo.toString());
    }
}
