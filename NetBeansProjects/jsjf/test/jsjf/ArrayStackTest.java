package jsjf;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hagen
 */
public class ArrayStackTest {

    private ArrayStack<Integer> pila;

    public ArrayStackTest() {
    }

    @Before
    public void setUp() {
        pila = new ArrayStack<>();
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
        assertTrue(pila.isEmpty());
        pila.add(3);
        pila.add(5);
        pila.clear();
        assertTrue(pila.isEmpty());
    }

    /**
     * Test of isEmpty method, of class ArrayStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertTrue(pila.isEmpty());
    }

    /**
     * Test of push method, of class ArrayStack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        assertTrue(pila.isEmpty());
        pila.add(3);
        assertFalse(pila.isEmpty());
    }

    /**
     * Test of pop method, of class ArrayStack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        assertTrue(pila.isEmpty());
        pila.add(3);
        pila.remove();
        assertTrue(pila.isEmpty());
    }

    /**
     * Test of peek method, of class ArrayStack.
     */
    @Test
    public void testPeek() {
        pila.add(3);
        System.out.println(pila.peek());

    }

}
