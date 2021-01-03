package figurasgeometricas;

public class TrianguloEquilatero extends Triangulo implements Comparable<TrianguloEquilatero> {

    private double lado;

    public TrianguloEquilatero(double lado) {
        super(lado, lado, lado);
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public double getAltura() {
        return lado * Math.sin(Math.PI / 3);
    }

    @Override //Este override se agrega para indicar que voy a sobreescribir un método al que hacía referencia
    //pero no es necesario
    public double calPerimetro() {
        return 3 * lado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.lado) ^ (Double.doubleToLongBits(this.lado) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TrianguloEquilatero other = (TrianguloEquilatero) obj;
        if (Double.doubleToLongBits(this.lado) != Double.doubleToLongBits(other.lado)) {
            return false;
        }
        return true;
    }

    public int compareTo(TrianguloEquilatero otro) {
        return Double.compare(this.lado, otro.lado);
    }

}
