package recursividad;

/**
 *
 * @author Hagen
 */
public class Ejercicio {

  public static int factorial(int n) {
    int res = 0;
    if (n == 1 || n == 0) {
      res = 1;
    } else {
      res = n * factorial(n - 1);
    }
    return res;
  }

  public static void imprimeNumeros(int n) {
    System.out.println(n);
    if (n >= 1) {
      imprimeNumeros(n - 1);
    }
  }

  public static void imprimeNumerosOrdenados(int n) {
    if (n >= 1) {
      imprimeNumerosOrdenados(n - 1);
      System.out.println(n);
    } else {
      System.out.println(n);
    }
  }

  public static int suma(int arreglo[]) { //Asumimos que esta lleno
    return apoyoSuma(arreglo, arreglo.length - 1);
  }

  public static int apoyoSuma(int arreglo[], int n) {
    if (n == 0) {
      return arreglo[0];
    } else {
      return arreglo[n] + apoyoSuma(arreglo, n - 1);
    }
  }

  public static int sumaV2(int arreglo[]) {
    return apoyoSumaV2(arreglo, arreglo.length - 1, 0);
  }

  public static int apoyoSumaV2(int arreglo[], int n, int suma) {
    if (n == 0) {
      return arreglo[0] + suma;
    } else {
      return apoyoSumaV2(arreglo, n - 1, suma + arreglo[n]);
    }
  }

  public static int euclides(int a, int b) { //Son statics porque estan en un main y los quiero llamar abajo
    int r = a % b;
    if (r == 0) {
      return b;
    } else {
      return euclides(b, r);
    }
  }

  public static int euclidesIterativo(int a, int b) { //ITERATIVO
    int aux;
    while (b != 0) {
      aux = b;
      b = a % b;
      a = aux;
    }
    return a;
  }

  public static int sumaDigitos(int n) {
    if (n < 10) {
      return n;
    } else {
      return n % 10 + sumaDigitos(n / 10);
    }
  }

  public static int sumaDigitos2(int n) {
    return sumaDigitos2(Math.abs(n), 0); //Así evito negativos
  }

  public static int sumaDigitos2(int n, int suma) {//Si hay 2 métodos con el mismo nombre le hablaremos al que coincida con los parámetros que le demos
    if (n < 10) {
      return n + suma;
    } else {
      return sumaDigitos2(n / 10, suma + n % 10);
    }
  }

  public static int sumaImpares(int datos[], int n) {
    if (n - 1 == 0) {
      /*if (datos[0] % 2 != 0) { //otra manera de hacer if
        return datos[0];
      } else {
        return 0;
      }*/
      return datos[0] % 2 != 0 ? datos[0] : 0;
    } else {
      return datos[n - 1] % 2 != 0 ? sumaImpares(datos, n - 1) + datos[n - 1] : sumaImpares(datos, n - 1);
    }
    /*if (datos[n - 1] % 2 != 0) {
      return sumaImpares(datos, n - 1) + datos[n - 1];
    } else {
      return sumaImpares(datos, n - 1);
    }*/
  }

  public static String reverseString(String str) {
    if (str.length() == 1) {
      return str;
    } else {
      return reverseString(str.substring(1))+str.charAt(0);//crea una cadena que empieza en el lugar 1 de la anterior, no la 0
    }
  }
  
  public static String quitaBlancos(String str){
    if(str.length()==1){
      return str;
    }
    else
      return str.charAt(0)==' ' ?quitaBlancos(str.substring(1)) : str.charAt(0)+quitaBlancos(str.substring(1));
  }
  
  public static void convierteABinarios(int n){
    if(n>0){
      convierteABinarios(n/2);//Recordar que el odren de estas 2 afecta si aparece normal o de cabeza.
      System.out.print(n%2);//Estas 2
    } 
  }

  public static void main(String[] args) {
    int n[] = {1, 2, 3, 4, 5, 6, 7, 8};
    System.out.println(factorial(8));
    imprimeNumeros(8);
    imprimeNumerosOrdenados(8);
    System.out.println(sumaV2(n));
    System.out.println(euclides(24, 16));
    System.out.println(sumaDigitos(4452));
    System.out.println(sumaDigitos2(4452));
    System.out.println(sumaImpares(n, 8));
    System.out.println(reverseString("abc"));
    convierteABinarios(9638);
  }
}
