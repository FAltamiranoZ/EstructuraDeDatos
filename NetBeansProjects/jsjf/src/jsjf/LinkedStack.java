package jsjf;

import jsjf.exceptions.EmptyCollectionException;

/**
 *
 * @author Hagen
 */
public class LinkedStack<T> implements StackADT<T> {

    protected LinearNode<T> top;

    public LinkedStack() {
        clear();
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("pila");
        } else {
            return top.getElemento();
        }
    }

    @Override
    public void add(T x) {
        LinearNode<T> nodo = new LinearNode<>(x);
        nodo.setNext(top);
        top = nodo;
    }

    public T remove() {
        T res = peek();
        top = top.getNext();
        return res;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

}
