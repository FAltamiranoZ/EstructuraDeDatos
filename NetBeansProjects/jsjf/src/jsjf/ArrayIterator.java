package jsjf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Hagen
 * @param <T>
 */
public class ArrayIterator<T> implements Iterator<T> {

    private int contador;
    private final int tot;
    private final T[] collection;

    public ArrayIterator(T[] coleccion, int total) {
        tot = total;
        collection = coleccion;
        contador = 0;
    }

    @Override
    public boolean hasNext() {
        return contador < tot;
    }

    @Override
    public T next() throws NoSuchElementException {
        if (hasNext()) {
            return collection[contador++];
        } else {
            throw new NoSuchElementException();
        }
    }

}
