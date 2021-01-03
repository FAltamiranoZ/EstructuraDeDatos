package jsjf;

import java.util.Arrays;

/**
 *
 * @author Hagen
 */
public abstract class ArrayLinearCollection<T> {

    protected T[] collection; //Este protected es para poderla usar abajo.
    protected int next;
    private final int INICIAL = 10;

    public ArrayLinearCollection() {
        clear();
    }

    public void clear() {
        collection = (T[]) new Object[INICIAL];
        next = 0;
    }

    protected int size() {
        return next;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    protected boolean isFull() {
        return size() == collection.length;
    }

    public void add(T elemento) {
        if (isFull()) {
            expandCapacity();
        }
        collection[next++] = elemento;
    }

    private void expandCapacity() {
        collection = Arrays.copyOf(collection, collection.length * 2);
    }

    public abstract T remove(); //Abstractos llevan ; no {}

}
