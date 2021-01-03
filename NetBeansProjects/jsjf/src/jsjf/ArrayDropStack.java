package jsjf;

/**
 * Pila que empuja el único elemento en lugar de expander la capacidad.
 *
 * @author Hagen
 */
public class ArrayDropStack<T> extends ArrayStack<T> {

    public ArrayDropStack() {
        super();
    }

    public void push(T elemento) {
        int i;
        if (isFull()) {
            for (i = 0; i < next - 1; i++) {
                collection[i] = collection[i + 1];
            }
            next--;
        }
        super.add(elemento);
    }
}
