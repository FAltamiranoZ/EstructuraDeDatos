package jsjf;

import java.util.Iterator;

/**
 *
 * @author Hagen
 * @param <T>
 */
public class LinkedQueueIterable<T> extends LinkedQueue<T>
        implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new LinkedIteratorSingleNode<T>(inicio);
    }

}
