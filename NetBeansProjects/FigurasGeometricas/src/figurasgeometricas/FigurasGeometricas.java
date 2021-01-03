package figurasgeometricas;

import java.util.ArrayList;

public class FigurasGeometricas {

    public static ArrayList<Figura2D> creacion() {
        ArrayList lista = new ArrayList<>();
        Cuadrado c = new Cuadrado(2);
        lista.add(c);
        lista.add(new Circulo(1));
        lista.add(new Elipse(2, 4));
        lista.add(new TrianguloEquilatero(3));
        lista.add(new Rombo(2.5, 60));

        return lista;
    }

    public static void procesamiento(ArrayList<Figura2D> lista) {
        double area = 0, perimetro = 0;
        int numPoligonos = 0, numLados = 0, numCirculos = 0;
        for (Figura2D figura : lista) {//for(int i=0;i<lista.size();i++) //Otra manera de hacer for, sirve para todas las
            //colecciones que tengan un ¿iterador? wtf is that
            area += figura.calArea();//area+=lista.get(i).calArea();
            perimetro += figura.calPerimetro();
            if (figura instanceof Poligono) {//Dice si posee el atributo a continuacion especificado
                numPoligonos++;
                numLados += ((Poligono) figura).getNumLados();
            }
            if (figura.getClass().getSimpleName().equals("Circulo")) //Recupera el nombre de la clase, sirve para buscar
            //una en específico, no un atributo de una o más como el anterior. Estos 2 vienen en el examen
            {
                numCirculos++;
            }
        }
        System.out.println(area + "\n" + perimetro + "\n" + numPoligonos + "\n" + numLados + "\n" + numCirculos);
    }

    public static void main(String[] args) {
        ArrayList<Figura2D> lista = FigurasGeometricas.creacion();
        FigurasGeometricas.procesamiento(lista);
    }

}
