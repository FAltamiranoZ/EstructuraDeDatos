package jsjf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Hagen
 * @param <T>
 */
public class LinkedIteratorSingleNode<T> implements Iterator<T> {

    private LinearNode<T> siguiente;

    public LinkedIteratorSingleNode(LinearNode<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public boolean hasNext() {
        return siguiente != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T resultado = siguiente.getElemento();
        siguiente = siguiente.getNext();
        return resultado;

    }

}
