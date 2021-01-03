package jsjf;

import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author edi
 */
public class Conjunto<T> implements SetADT<T> {

    private IndexedLinkedList<T> lista;
    private final Random R = new Random();
    
    public Conjunto(){
        clear();
    }
    
    public boolean equals(SetADT<T> otro) {
        if(this.size() != otro.size())
            return false;
        else
            return equals(otro, this.iterator());
    }
    
    public boolean equals(SetADT<T> otro, Iterator<T> it){
        if(!it.hasNext())
            return true;
        if(!otro.contains(it.next()))
            return false;
        else
            return equals(otro, it);
    }

    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public boolean contains(T elemento) {
        return lista.contains(elemento);
    }

    @Override
    public T remove(T elemento) {
        return lista.remove(elemento);
    }

    @Override
    public void add(T x) {
       lista.add(x);
    }

    @Override
    public T remove() {
        return lista.remove(R.nextInt(size()));
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public void clear() {
        lista = new IndexedLinkedList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return lista.iterator();
    }
    
}
