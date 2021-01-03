package jsjf;

import jsjf.exceptions.EmptyCollectionException;

/**
 *
 * @author Hagen
 */
public class ArrayQueue<T> extends ArrayLinearCollection<T> implements QueueADT<T> {

    public ArrayQueue() {
        super();
    }

    public T remove() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("cola");
        }
        T res = first();
        for (int i = 0; i < next; i++) {
            collection[i] = collection[i + 1];
        }
        next--;
        collection[next] = null;
        return res;
    }

    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("cola");
        } else {
            return (T) collection[0];
        }
    }
}
