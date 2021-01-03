package figurasgeometricas;

public class Rectangulo extends Poligono implements Comparable<Rectangulo> {

    private double diagonalMayor, diagonalMenor, lado;

    public Rectangulo(double lado) {
        super(new double[]{lado, lado, lado, lado});
        this.lado = lado;
    }

    public double getDiagonalMayor() {
        return diagonalMayor;
    }

    public double getDiagonalMenor() {
        return diagonalMenor;
    }

    public double getLado() {
        return lado;
    }

    public double calArea() {
        double res = -1;
        res = (diagonalMayor * diagonalMenor);
        return res;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.diagonalMayor) ^ (Double.doubleToLongBits(this.diagonalMayor) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.diagonalMenor) ^ (Double.doubleToLongBits(this.diagonalMenor) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.lado) ^ (Double.doubleToLongBits(this.lado) >>> 32));
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
        final Rectangulo other = (Rectangulo) obj;
        if (Double.doubleToLongBits(this.diagonalMayor) != Double.doubleToLongBits(other.diagonalMayor)) {
            return false;
        }
        if (Double.doubleToLongBits(this.diagonalMenor) != Double.doubleToLongBits(other.diagonalMenor)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lado) != Double.doubleToLongBits(other.lado)) {
            return false;
        }
        return true;
    }

    public int compareTo(Rectangulo otro) {
        return Double.compare(this.calArea(), otro.calArea());
    }

}
