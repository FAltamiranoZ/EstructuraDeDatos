package exfinaledmayo2017;

/**
 *
 * @author
 */
public class ExFinalEDmayo2017 {
    //Método del problema 1. 
    public static boolean verificaLenguajeDick(String cadena) {
        if(cadena.length()==0)
            return true;
        Pila pila = new Pila();
        return verificaLenguajeDickR(cadena, 0, pila);
    }
    private static boolean verificaLenguajeDickR(String cadena, int i, Pila pila){
        if(i<=cadena.length())
            return true;
        if (cadena.charAt(i) == '(') {
                pila.push(')');
            } else if (cadena.charAt(i) == '{') {
                pila.push('}');
            } else if (cadena.charAt(i) == '[') {
                pila.push(']');
            } else if (cadena.charAt(i) == ')') {
                if(verifica(')', pila)==false)
                    return false;
            } else if (cadena.charAt(i) == '}') {
                if(verifica('}', pila)==false){
                    return false;
                }
            } else if (cadena.charAt(i) == ']') {
                if(verifica(']', pila)==false){
                    return false;
                }
            }
        return verificaLenguajeDickR(cadena, i++, pila);
    }
    private static boolean verifica(char x, Pila pila) {
        if (pila.isEmpty()) {
            return false;
        } else {
            Character y = (Character) pila.pop();
            if (x != y.charValue()) {
                return false;
            }
        }
        return true;
    }

    /* Método main para probar tus soluciones.
    * Puedes agregar todos los casos de prueba que creas conveniente para
    * asegurar que tus soluciones son correctas, completas y eficientes.
     */
    public static void main(String[] args) {

        //----  Problema 1 ----
        String cadena1, cadena2, cadena3, cadena4, cadena5, cadena6;

        cadena1 = "[8 + 3 * (5 + 2)]";
        cadena2 = "[8 + 3 * (5 + 2)";
        cadena3 = "[32 - 16 / [4 - 3]}";
        cadena4 = "{46 / 24 * (3 / ( 6 + 18)) * 15 - 3} + 16";
        cadena5 = "46 / 24 * (3 / (6 + 18)) * 15 - 3} + 16)";
        cadena6 = "{[(())]}";

        //Caso de prueba 1 - Solución problema 1
        System.out.println("\nResultado al evaluar la cadena 1: "
                + verificaLenguajeDick(cadena1));

        //Caso de prueba 2 - Solución problema 1
        System.out.println("\nResultado al evaluar la cadena 2: "
                + verificaLenguajeDick(cadena2));

        //Caso de prueba 3 - Solución problema 1
        System.out.println("\nResultado al evaluar la cadena 3: "
                + verificaLenguajeDick(cadena3));

        //Caso de prueba 4 - Solución problema 1
        System.out.println("\nResultado al evaluar la cadena 4: "
                + verificaLenguajeDick(cadena4));

        //Caso de prueba 5 - Solución problema 1
        System.out.println("\nResultado al evaluar la cadena 5: "
                + verificaLenguajeDick(cadena5));

        //Caso de prueba 6 - Solución problema 1
        System.out.println("\nResultado al evaluar la cadena 6: "
                + verificaLenguajeDick(cadena6));

        //----  Problema 2 ----
        ListaDesordenada<Integer> lisNum1 = new ListaDesordenada();
        lisNum1.agregaFinal(6);
        lisNum1.agregaFinal(7);
        lisNum1.agregaFinal(8);
        lisNum1.agregaFinal(9);
        lisNum1.agregaFinal(10);
        lisNum1.agregaFinal(4);

        //Caso de prueba 1 - Solución problema 2
        System.out.println("\n\nLista 1 antes de cambiar el 8:   " + lisNum1);
        lisNum1.cambiaOrden(8);
        System.out.println("\nLista 1 después de cambiar el 8:   " + lisNum1);

        ListaDesordenada<Integer> lisNum2 = new ListaDesordenada();
        lisNum2.agregaFinal(6);
        lisNum2.agregaFinal(7);
        lisNum2.agregaFinal(8);
        lisNum2.agregaFinal(9);
        lisNum2.agregaFinal(8);
        lisNum2.agregaFinal(4);
        lisNum2.agregaFinal(8);
        lisNum2.agregaFinal(8);
        lisNum2.agregaFinal(2);

        //Caso de prueba 2 - Solución problema 2
        System.out.println("\n\nLista 2 antes de cambiar el 8:   " + lisNum2);
        lisNum2.cambiaOrden(8);
        System.out.println("\nLista 2 después de cambiar el 8:   " + lisNum2);

        //----  Problema 3 ----
        Empresa unaEmp = new Empresa();
        unaEmp.altaCamion("Volvo", "AX24-128TR", "PAB-204", 6.5);
        unaEmp.altaCamion("Mercedes", "BJT1-706AA", "BUN-693", 4.0);
        unaEmp.altaCamion("Volvo", "JL98-325PL", "NAB-411", 40);
        unaEmp.altaCamion("Volvo", "SW88-145QW", "LAC-887", 35);
        unaEmp.altaCamion("Ford", "AQ35-589YR", "YQG-222", 40);
        unaEmp.altaCamion("GM", "POU0-457HY", "COL-975", 45);
        unaEmp.altaCamion("Volvo", "BB33-215CC", "TAN-356", 5.7);

        System.out.println("\nLista de camiones antes de modificar: "
                + unaEmp.generaReporteCamiones());

        //Caso de prueba 1 - Solución problema 3
        int res = unaEmp.incrementaPasajerosPorMarca("Volvo", 5);
        System.out.println("\n" + res + " modificaciones realizadas");
        System.out.println("Lista de camiones luego de modificar Volvo: "
                + unaEmp.generaReporteCamiones());

        //Caso de prueba 2 - Solución problema 3
        res = unaEmp.incrementaPasajerosPorMarca("Mercedes", 8);
        System.out.println("\n" + res + " modificaciones realizadas");
        System.out.println("Lista de camiones luego de modificar Mercedes: "
                + unaEmp.generaReporteCamiones());

    }

}
