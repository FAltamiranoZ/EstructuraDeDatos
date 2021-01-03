package jsjf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author edi
 */
public class HashSetIterator<T> implements Iterator<T> {

    private UnorderedLinkedList<T> [] tabla;
    private int count, renglon;
    private Iterator<T> itR;

    public HashSetIterator(UnorderedLinkedList<T>[] tabla, int count) {
        this.tabla = tabla;
        this.count = count;
        renglon = 0;
        itR = tabla[renglon].iterator();
    }
    
    @Override
    public boolean hasNext() {
        return count > 0;
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException("HashSetIterator");
        while(!itR.hasNext()){
            renglon++;
            itR = tabla[renglon].iterator();
        }
        count--;
        return itR.next();
    }
    
}
