package jsjf;

import java.util.Iterator;

/**
 *
 * @author Hagen
 * @param <T>
 */
public class LinkedStackIterable<T> extends LinkedStack<T>
        implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new LinkedIteratorSingleNode<T>(top);
    }

}
