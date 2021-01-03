package jsjf;

/**
 *
 * @author Hagen
 */
public interface SetADT<T> extends LinearCollectionIterable<T>{

    public boolean equals(SetADT<T> otro);
    
}
