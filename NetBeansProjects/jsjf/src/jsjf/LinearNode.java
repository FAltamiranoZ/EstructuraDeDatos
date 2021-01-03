package jsjf;

/**
 *
 * @author Hagen
 */
public class LinearNode<T> {

    private T elemento;
    private LinearNode<T> next;

    public LinearNode() {
        clear();
    }

    public void clear() {
        elemento = null;
        next = null;
    }

    public LinearNode(T elemento) {
        this.elemento = elemento;
        next = null;
    }

    public LinearNode(T elemento, LinearNode<T> next) {
        this.elemento = elemento;
        this.next = next;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public LinearNode<T> getNext() {
        return next;
    }

    public void setNext(LinearNode<T> next) {
        this.next = next;
    }

}
