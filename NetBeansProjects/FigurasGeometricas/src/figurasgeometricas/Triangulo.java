package figurasgeometricas;

public abstract class Triangulo extends Poligono {//Lo hice abstracto porque no quiero crear otro triángulo
    //y no le puse comparable porque quiero comparar equilateros con equilateros, no equilateros con isóceles.

    public Triangulo(double lado1, double lado2, double lado3) {
        super(new double[]{lado1, lado2, lado3});
    }

    public double calArea() {
        double s = calPerimetro() / 2;
        return Math.sqrt(s * (s - lados[0]) * (s - lados[1]) * (s - lados[2]));
    }

}
