//Pila (LIFO) Last Input, First Output
//Stack ADT (Interfaz en la que se dice el tipo de operaciones que debe de tener la pila)
//ArrayStack (Implementa el Stack usando arreglos)
package jsjf;

/**
 * Métodos para una pila.
 *
 * @author Hagen
 * @param <T>
 */
public interface StackADT<T> extends LinearCollection<T> {//La T es un objeto Genérico.
    //En una interfaz, todos los métodos son publicos y pueeeeden ser abstractos si quieres.
    //Las interfaces no llevan cuerpo es decir: {}.

    /**
     * Regresa el último elemento que haya entrado.
     *
     * @return último elemento de la fila sin removerlo.
     */
    public T peek();
}
