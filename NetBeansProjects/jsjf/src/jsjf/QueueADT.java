//Cola (FIFO) First Input, First Output
package jsjf;

/**
 * Métodos necesarios para una cola.
 *
 * @author JALTAMIRZ
 */
public interface QueueADT<T> extends LinearCollection<T> {

    /**
     * Regresa el primer elemento que haya entrado.
     *
     * @return primer elemento de la fila sin removerlo.
     */
    public T first();
}
