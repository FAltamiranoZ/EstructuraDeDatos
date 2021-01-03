package jsjf;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Hagen
 */
public class ArrayQueueTest {

    private ArrayQueue<Integer> cola;

    public ArrayQueueTest() {
    }

    @Before
    public void setUp() {
        cola = new ArrayQueue<>();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of clear method, of class ArrayStack.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        cola.add(5);
        cola.add(3);
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
        cola.add(1);
        assertFalse(cola.isEmpty());
    }

    /**
     * Test of enqueue method, of class ArrayStack.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        assertTrue(cola.isEmpty());
        cola.add(3);
        assertFalse(cola.isEmpty());
    }

    /**
     * Test of dequeue method, of class ArrayStack.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        cola.add(3);
        cola.remove();
        assertTrue(cola.isEmpty());
    }

    /**
     * Test of first method, of class ArrayStack.
     */
    @Test
    public void testFirst() {
        cola.add(3);
        System.out.println(cola.first());
    }

}
