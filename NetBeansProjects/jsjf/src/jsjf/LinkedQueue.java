package jsjf;

import jsjf.exceptions.EmptyCollectionException;

/**
 *
 * @author Hagen
 */
public class LinkedQueue<T> implements StackADT<T> {

    protected LinearNode<T> inicio, fin;

    public LinkedQueue() {
        clear();
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("pila");
        } else {
            return inicio.getElemento();
        }
    }

    @Override
    public void add(T x) {
        LinearNode<T> nodo = new LinearNode<>(x);
        if (isEmpty()) {
            inicio = nodo;
        } else {
            fin.setNext(nodo);
        }
        fin = nodo;
    }

    
    public T remove() {
        T res = peek();
        inicio = inicio.getNext();
        if (isEmpty()) {
            clear();
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        return inicio == null;
    }

    @Override
    public void clear() {
        inicio = null;
        fin = null;
    }

}
