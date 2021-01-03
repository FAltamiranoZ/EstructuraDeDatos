package jsjf;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Hagen
 */
public class CircularArrayQueueTest {

    private CircularArrayQueue<Integer> cola;

    public CircularArrayQueueTest() {
    }

    @Before
    public void setUp() {
        cola = new CircularArrayQueue<>();
    }

    /**
     * Test of clear method, of class ArrayStack.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        assertTrue(cola.isEmpty());
        cola.add(8);
        assertFalse(cola.isEmpty());
        cola.clear();
        assertTrue(cola.isEmpty());
    }

    /**
     * Test of isEmpty method, of class ArrayStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertTrue(cola.isEmpty());
        cola.add(3);
        assertFalse(cola.isEmpty());
        cola.remove();
        assertTrue(cola.isEmpty());
    }

    /**
     * Test of enqueue method, of class ArrayStack.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        assertTrue(cola.isEmpty());
        cola.add(4);
        assertFalse(cola.isEmpty());
        System.out.println(cola.first());
        cola.add(5);
        cola.add(7);
        cola.add(2);
        cola.add(35);
        cola.add(9);
        cola.remove();
        cola.add(8);
        System.out.println(cola.first());
        cola.remove();
        System.out.println(cola.first());
        assertFalse(cola.isEmpty());
    }

    /**
     * Test of dequeue method, of class ArrayStack.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        assertTrue(cola.isEmpty());
        cola.add(3);
        assertFalse(cola.isEmpty());
        cola.remove();
        assertTrue(cola.isEmpty());
        cola.add(3);
        cola.add(4);
        cola.add(5);
        assertFalse(cola.isEmpty());
        cola.remove();
        assertFalse(cola.isEmpty());
        cola.remove();
        assertFalse(cola.isEmpty());
        cola.remove();
        assertTrue(cola.isEmpty());
    }

    /**
     * Test of first method, of class ArrayStack.
     */
    @Test
    public void testFirst() {
        assertTrue(cola.isEmpty());
        cola.add(3);
        assertFalse(cola.isEmpty());
        System.out.println(cola.first());

    }

}
