package caballo;


import java.util.Scanner;
import java.util.Random;

public class Caballo {  // Abre clase Caballo

    private int x = 4;
    private int y = 5;
    private int tamano = 8;
    private int contador = 1;
    int ciclos = 0;                         
    int intentos_fallidos = 0;

    Scanner entrada = new Scanner(System.in);

    public void Recibe() {  // Abre Recibe
        Random aleatorio = new Random();

        int Arreglo[][] = new int[tamano + 1][tamano + 1];
// Se define el arreglo de 9*9 para evitar el 0 
        Arreglo[4][5] = 1;
        int dado1;
        int dado2;
        int casillas_requeridas = 64;

        while (contador < casillas_requeridas) {
            intentos_fallidos++;
            contador = 1; 
            int ciclos = 0; 
            for (int s = 0; s <= tamano; s++) {       // Abre for
                for (int t = 0; t <= tamano; t++) {
                    Arreglo[s][t] = 0;
                }
            }       // cierra for 

            x = 4;
            y = 5;

            Arreglo[4][5] = 1;

            while (1000 != ciclos)
            {  // Abre while
                ciclos++;
                dado1 = 1 + aleatorio.nextInt(8);
                dado2 = 1 + aleatorio.nextInt(8);

                if (Math.abs(Math.abs(x) - Math.abs(dado1)) == 2) { // Abre if
                    if (Math.abs(Math.abs(y) - Math.abs(dado2)) == 1) {
                        if (0 == Arreglo[dado1][dado2]) {   // Abre if
                            Arreglo[dado1][dado2] = ++contador;
                            x = dado1;
                            y = dado2;
                            ciclos = 0;
                        }  // Cierra if 
                    }
                }  //Cierra if 

                if (Math.abs(Math.abs(x) - Math.abs(dado1)) == 1) {  // abre if
                    if (Math.abs(Math.abs(y) - Math.abs(dado2)) == 2) {
                        if (0 == Arreglo[dado1][dado2]) {    // Abre if 
                            Arreglo[dado1][dado2] = ++contador;
                            x = dado1;
                            y = dado2;
                            ciclos = 0;
                        }  // Cierra if
                    }
                }  // Cierra if

            }  // Cierra while anidado
        }    // Cierra while

        System.out.println("\nLISTO!");
        System.out.printf("\nSe recorrieron %d casillas.\n", contador);
        System.out.printf("\nSe intentaron %d circuitos antes de obtener el requerido.\n", intentos_fallidos);
        Imprime(Arreglo);

    }   // Cierra Recibe

    /*El metodo siguiente despliega el tablero de ajedrez */
//////////////////////////////////////////
// Imprime
///////////////////////////////////////////
    public void Imprime(int B[][]) {     // Abre imprime
        for (int k = 1; k <= 8; k++) {
            for (int j = 1; j <= 8; j++) {
                System.out.printf("%5d", B[k][j]);

            }
            System.out.println("\n");
        }
    }     // Cierra imprime

    public static void main(String[] args) {
        Caballo miObjeto = new Caballo();
        miObjeto.Recibe();
    }
}    // Cierra clase Caballo 
