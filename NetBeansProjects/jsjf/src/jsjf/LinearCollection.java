package jsjf;

/**
 *
 * @author Hagen
 */
public interface LinearCollection<T> {

    void add(T x);

    T remove();

    /**
     * Función: Dice si la pila esta vacia o no.
     *
     * @return verdadero: vacio; falso: != de vacio //Este return lo genera
     * javadoc porque regresa algo el método.
     */
    boolean isEmpty();

    /**
     * Función: Remueve todos los elementos de la pila.
     */
    void clear();

}
