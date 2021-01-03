package exfinaledmayo2017;
import java.util.*;

public class Iterador <T> implements Iterator <T> {
    private Nodo <T> actual;

    public Iterador(Nodo <T> actual) {
        this.actual = actual;
    }
    
    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        else {
            T resul = actual.getDato();
            actual = actual.getSig();
            return resul;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("No está implementada la operación.");
    }
}
