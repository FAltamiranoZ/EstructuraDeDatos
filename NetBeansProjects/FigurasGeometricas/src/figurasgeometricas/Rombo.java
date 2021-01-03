package figurasgeometricas;

public class Rombo extends Poligono implements Comparable<Rombo> {

    private double lado, angulo, anguloRadianes;

    public Rombo(double lado, double angulo) {
        super(new double[]{lado, lado, lado, lado});
        this.lado = Math.abs(lado);
        this.angulo = Math.abs(angulo);
        anguloRadianes = 2 * Math.PI * angulo / 360;
    }

    public double getLado() {
        return lado;
    }

    public double getAngulo() {
        return angulo;
    }

    public double getAnguloRadianes() {
        return anguloRadianes;
    }

    public double calArea() {
        return lado * lado * Math.sin(anguloRadianes);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.lado) ^ (Double.doubleToLongBits(this.lado) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.angulo) ^ (Double.doubleToLongBits(this.angulo) >>> 32));
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
        final Rombo other = (Rombo) obj;
        if (Double.doubleToLongBits(this.lado) != Double.doubleToLongBits(other.lado)) {
            return false;
        }
        if (Double.doubleToLongBits(this.angulo) != Double.doubleToLongBits(other.angulo)) {
            return false;
        }
        return true;
    }

    public int compareTo(Rombo otro) {
        return Double.compare(this.calArea(), otro.calArea());
    }
}
