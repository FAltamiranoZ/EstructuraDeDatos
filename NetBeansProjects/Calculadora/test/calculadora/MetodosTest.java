package calculadora;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author edi
 */
public class MetodosTest {

    public MetodosTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isBalanced method, of class Metodos.
     */
    @Test
    public void testIsBalanced() {
        System.out.println("isBalanced");
        String expresion = "(2+3)*[5/3]";
        boolean expResult = false;
        boolean result = Metodos.isBalanced(expresion);
        assertEquals(expResult, result);
        assertFalse(Metodos.isBalanced("(5-3)-(2*5]"));
        assertFalse(Metodos.isBalanced("[2*1)/[5+2}"));
        assertFalse(Metodos.isBalanced("(2+3*[5/3]"));
        assertFalse(Metodos.isBalanced("(2+3)*[5/3"));
        assertTrue(Metodos.isBalanced("( ( 2+3 ) * ( 5/3 ) )"));
    }

    /**
     * Test of isOpeningParentheses method, of class Metodos.
     */
    @Test
    public void testIsOpeningParentheses() {
        System.out.println("isOpeningParentheses");
        String token = "";
        boolean expResult = false;
        boolean result = Metodos.isOpeningParentheses(token);
        assertEquals(expResult, result);
        assertTrue(Metodos.isOpeningParentheses("("));
        assertTrue(Metodos.isOpeningParentheses("["));
        assertTrue(Metodos.isOpeningParentheses("{"));
        assertFalse(Metodos.isOpeningParentheses(")"));
        assertFalse(Metodos.isOpeningParentheses("]"));
        assertFalse(Metodos.isOpeningParentheses("}"));
        assertFalse(Metodos.isOpeningParentheses("+"));
        token = "3.1416"; //Esta es otra manera más lenta
        assertFalse(Metodos.isOpeningParentheses(token));
    }

    /**
     * Test of isClosingParentheses method, of class Metodos.
     */
    @Test
    public void testIsClosingParentheses() {
        System.out.println("isClosingParentheses");
        String token = "";
        boolean expResult = false;
        boolean result = Metodos.isClosingParentheses(token);
        assertEquals(expResult, result);
        assertFalse(Metodos.isClosingParentheses("("));
        assertFalse(Metodos.isClosingParentheses("["));
        assertFalse(Metodos.isClosingParentheses("{"));
        assertTrue(Metodos.isClosingParentheses(")"));
        assertTrue(Metodos.isClosingParentheses("]"));
        assertTrue(Metodos.isClosingParentheses("}"));
        assertFalse(Metodos.isClosingParentheses("+"));
        token = "3.1416"; //Esta es otra manera más lenta
        assertFalse(Metodos.isClosingParentheses(token));
    }

    /**
     * Test of agree method, of class Metodos.
     */
    @Test
    public void testAgree() {
        System.out.println("agree");
        String token1 = "";
        String token2 = "";
        boolean expResult = false;
        boolean result = Metodos.agree(token1, token2);
        assertEquals(expResult, result);
        assertTrue(Metodos.agree("(", ")"));
        assertTrue(Metodos.agree("[", "]"));
        assertTrue(Metodos.agree("{", "}"));
        assertFalse(Metodos.agree("(", "["));
        assertFalse(Metodos.agree("(", "{"));
        assertFalse(Metodos.agree("[", "("));
        assertFalse(Metodos.agree("[", "{"));
        assertFalse(Metodos.agree("{", "("));
        assertFalse(Metodos.agree("{", "["));
    }

    /**
     * Test of operation method, of class Metodos.
     */
    /*
  @Test
  public void testOperation() {
    System.out.println("operation");
    double op1 = 3.2;
    double op2 = 2.0;
    String op = "+";
    double expResult = 5.2;
    double result = Metodos.operation(op1, op2, op);
    assertEquals(expResult, result, 0.00000001);
    assertEquals(1.2, Metodos.operation(op1,op2"-"), 0.0000001);
  }
     */
}
