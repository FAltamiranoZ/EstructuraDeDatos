package jsjf;

import java.util.Iterator;

/**
 *
 * @author Hagen
 */
public class Jsjf {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ArraySet<String> ejemplo = new ArraySet<>();
    Iterator<String> it;

    ejemplo.add("1234");
    ejemplo.add("5678");
    ejemplo.add("qwerty");
    ejemplo.add("asdf");
    ejemplo.add("zxcv");
    it = ejemplo.iterator();

    while (it.hasNext()) {
      System.out.println(it.next().toString());
    }

    for (String elemento : ejemplo) {
      System.out.println(elemento.toUpperCase());
    }

    System.out.println(ejemplo);

  }

}
