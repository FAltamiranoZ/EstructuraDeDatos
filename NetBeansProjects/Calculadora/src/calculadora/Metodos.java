package calculadora;

import java.util.Scanner;
import jsjf.ArrayStack;
import jsjf.StackADT;
import jsjf.exceptions.EmptyCollectionException;

/**
 *
 * @author Hagen
 */
public class Metodos {

    public static boolean isBalanced(String expresion) {
        StackADT<String> stack = new ArrayStack<>(); //Para poder traer este método de
        //otro paquete, vamos al nombre del paquete, click derecho,
        //set configuration, customize, libraries, add project.
        boolean res = false;
        String token;
        Scanner sc = new Scanner(expresion);
        try {
            while (sc.hasNext() && res) {
                token = sc.next();
                if (isOpeningParentheses(token)) {
                    stack.add(token);
                } else if (isClosingParentheses(token)) {
                    res = agree(stack.remove(), token);
                }
            }
        } catch (EmptyCollectionException e) {
            res = false;
        }
        return res;
    }

    public static boolean isOpeningParentheses(String token) {
        boolean res = false;
        if (token.equals("(") || token.equals("[") || token.equals("{")) {
            res = true;
        }
        /*
    if(token.equals("("))
      res=true;
    else{
      if(token.equals("["))
        res=true;
      else if(token.equals("{"))//Maner más rápida.
          res=true;
    }
         */
        return res;
    }

    public static boolean isClosingParentheses(String token) {
        boolean res = false;
        if (token.equals(")") || token.equals("]") || token.equals("}")) {
            res = true;
        }
        return res;
    }

    public static boolean agree(String token1, String token2) {
        boolean res = false;
        if ((token1.equals("(") && token2.equals(")")) || (token1.equals("[") && token2.equals("]")) || (token1.equals("{") && token2.equals("}"))) {
            res = true;
        }
        return res;
    }

    public static boolean isOperator(String token) {
        return false;
    }

    public static boolean isGreater(String token1, String token2) {
        return false;
    }

    public static double operation(double op1, double op2, String op) {
        double res;
        switch (op) {
            case "+":
                res = op1 + op2;
                break;
            case "-":
                res = op1 - op2;
                break;
            case "*":
                res = op1 * op2;
                break;
            case "/":
                res = op1 / op2;
                break;
            default:
                res = 0.0;

        }
        return res;
    }

}
