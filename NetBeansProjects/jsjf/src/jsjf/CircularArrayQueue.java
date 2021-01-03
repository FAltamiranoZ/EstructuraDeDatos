package jsjf;

import jsjf.exceptions.EmptyCollectionException;
//Todos los incrementos o decrementos en un cola son con mod.

/**
 *
 * @author Hagen
 */
public class CircularArrayQueue<T> implements QueueADT<T> {

    protected T[] queue;
    protected int first, last, cont;
    private final int MAX = 5;

    public CircularArrayQueue() {
        clear();
    }

    public void clear() {
        queue = (T[]) new Object[MAX];
        first = 0;
        last = 0;
        cont = 0;
    }

    public boolean isEmpty() {
        return cont == 0;
    }

    public boolean isFull() {
        return cont == queue.length;
    }

    private void expandCapacity() {
        T[] n = (T[]) new Object[queue.length * 2];
        for (int i = 0; i <= cont; i++) {
            n[i] = queue[first];
            first = (first + 1) % queue.length;
        }
        queue = n;
        last = cont;
        first = 0;
    }

    public void add(T elemento) {
        if (isFull()) {
            expandCapacity();
        }
        if (isEmpty()) {
            queue[first] = elemento;
            last++;
        } else {
            queue[last++] = elemento;
        }
        cont++;
    }

    public T remove() {
        if (isEmpty()) {
            throw new EmptyCollectionException("cola");
        }
        T res = first();
        if (cont == 1) {
            clear();
        } else {
            for (int i = 0; i <= last; i++) {
                queue[i] = queue[i + 1];
            }
            cont--;
        }
        return res;
    }

    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("cola");
        } else {
            return queue[0];
        }
    }

}
