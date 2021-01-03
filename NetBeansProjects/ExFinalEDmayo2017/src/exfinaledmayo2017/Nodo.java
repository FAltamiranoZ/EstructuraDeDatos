package exfinaledmayo2017;

public class Nodo <T> {
    private T dato;
    private Nodo<T> sig;
    private Nodo<T> prev;        

    public Nodo() {
        dato = null;
        sig = null;
        prev = null;
    }

    public Nodo(T dato) {
        this.dato = dato;
        sig = null;
        prev = null;
    }

    public T getDato() {
        return dato;
    }

    public Nodo<T> getSig() {
        return sig;
    }
    
    public Nodo<T> getPrev() {
        return prev;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setSig(Nodo<T> sig) {
        this.sig = sig;
    }
    
    public void setPrev(Nodo<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return " " + dato;
    }
}
