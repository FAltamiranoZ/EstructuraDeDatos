package jsjf;

import jsjf.exceptions.EmptyCollectionException;

/**
 * Implemente una pila usando arreglos
 *
 * @author Hagen
 */
public class ArrayStack<T> extends ArrayLinearCollection<T> implements StackADT<T> {

    public ArrayStack() {
        super();
    }

    public T remove() {

        T res = peek();
        collection[--next] = null;
        return res;
    }

    /**
     * Regresa el último documento de la pila.
     *
     * @return
     * @throws EmptyCollectionException
     */
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("pila");
        } else {
            return collection[next - 1];
        }
    }

}
