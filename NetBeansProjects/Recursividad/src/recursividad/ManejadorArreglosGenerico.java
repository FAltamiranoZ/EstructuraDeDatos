package recursividad;

/**
 *
 * @author Hagen
 */
public class ManejadorArreglosGenerico {

  public static <T> String toString(T[] vector, int n) {//El problema especifica que no nos dan un contador
    if (n == 0) {
      return "";
    } else {
      return toString(vector, n, 0);
    }
  }

  public static <T> String toString(T[] vector, int n, int i) { //Para agregarlo, se usa un método extra
    if (i == n - 1) {
      return vector[i].toString();
    } else {
      return vector[i].toString() + toString(vector, n, i + 1);
    }
  }

  public static <T> String toString2(T[] vector, int n) {//En un solo método
    if (n == 0) {
      return "";
    }
    if (n - 1 == 0) {
      return vector[0].toString();
    }
    return toString(vector, n - 1) + vector[n - 1];
  }

  public static <T> int busquedaSecuencial(T[] vector, int n, T elemento) {
    if (n == 0) {
      return -1;
    } else {
      return busquedaSecuencial(vector, n, elemento, 0);
    }
  }

  public static <T> int busquedaSecuencial(T[] vector, int n, T elemento, int i) {
    if (i == n) {
      return -1;
    }
    if (vector[i].equals(elemento)) {
      return i;
    }
    return busquedaSecuencial(vector, n, elemento, ++i);//Si ya hay un return, el programa se detiene, por lo que no hace falta un else aquí    
  }

  public static <T extends Comparable> int mayor(T[] vector, int n) {
    if (n == 0) {
      return -1;
    } else {
      return mayor(vector, n, 1, 0);
    }
  }

  public static <T extends Comparable> int mayor(T[] vector, int n, int i, int max) {
    if (i == n) {
      return max;
    }
    if (vector[i].compareTo(vector[max]) > 0) {
      return mayor(vector, n, i + 1, i);
    } else {
      return mayor(vector, n, i + 1, max);
    }
  }

  public static <T extends Comparable> int busquedaSecuencialOrdenada(T[] vector, int n, T elemento) {
    if (n == 0) {
      return -1;
    } else {
      return busquedaSecuencialOrdenada(vector, n, elemento, 0);
    }
  }

  public static <T extends Comparable> int busquedaSecuencialOrdenada(T[] vector, int n, T elemento, int i) {
    if (i == n) {
      return -i - 1;
    }
    if (elemento.equals(vector[i])) {
      return i;
    }
    if (elemento.compareTo(vector[i]) < 0) {
      return -i - 1;
    }
    return busquedaSecuencialOrdenada(vector, n, elemento, i + 1);
  }

  public static <T extends Comparable> int busquedaBinaria(T[] vector, int n, T elemento) {
    if (n == 0) {
      return -1;
    }
    return busquedaBinaria(vector, n, elemento, 0);
  }

  public static <T extends Comparable> int busquedaBinaria(T[] vector, int n, T elemento, int inicio) {
    if (inicio == n) {
      return -inicio - 1;
    }
    if (elemento.equals(vector[(n + inicio) / 2])) {
      return n + inicio;
    }
    if (elemento.compareTo(vector[(n + inicio) / 2]) < 0) {
      return -((n + inicio) / 2) - 1;
    }
    return busquedaBinaria(vector, n, elemento, (n + inicio) / 2);
  }

}
