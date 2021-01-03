package figurasgeometricas;

public class Cuadrado extends Rombo {

    private double lado;

    public Cuadrado(double lado) {
        super(lado, 90);
        this.lado = lado;
    }

    @Override
    public String toString() {
        return "Cuadrado{" + "lado=" + lado + '}';
    }

}
