package jsjf;

import java.util.Random;
import jsjf.exceptions.ElementNotFoundException;

/**
 *
 * @author edi
 */
public class Pila<T> implements StackADT<T> {
    
    private IndexedLinkedList<T> lista;
    private final Random R = new Random();
    
    public Pila(){
        clear();
    }
    
    public void clear(){
        lista = new IndexedLinkedList<>();
    }

    @Override
    public T peek() {
        return lista.last();
    }

    @Override
    public void add(T x) {
        lista.add(x);
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public T remove() {
        return lista.remove(R.nextInt(size()));
    }
    
    public T remove(T elemento) throws ElementNotFoundException{
        return lista.remove(elemento);
    }
    
    private int size(){
        return lista.size();
    }
    
}
