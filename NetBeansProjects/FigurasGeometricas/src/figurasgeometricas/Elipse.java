package figurasgeometricas;

public class Elipse implements Figura2D, Comparable<Elipse> {

    private double ejeMayor, ejeMenor;

    public Elipse(double ejeMayor, double ejeMenor) {
        if (Math.abs(ejeMayor) > Math.abs(ejeMenor)) {
            this.ejeMayor = Math.abs(ejeMayor);
            this.ejeMenor = Math.abs(ejeMenor);
        } else {
            this.ejeMayor = Math.abs(ejeMenor);
            this.ejeMenor = Math.abs(ejeMayor);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.ejeMayor) ^ (Double.doubleToLongBits(this.ejeMayor) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.ejeMenor) ^ (Double.doubleToLongBits(this.ejeMenor) >>> 32));
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
        final Elipse other = (Elipse) obj;
        if (Double.doubleToLongBits(this.ejeMayor) != Double.doubleToLongBits(other.ejeMayor)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ejeMenor) != Double.doubleToLongBits(other.ejeMenor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Elipse{" + "ejeMayor=" + ejeMayor + ", ejeMenor=" + ejeMenor + '}';
    }

    public double calArea() {
        return Math.PI * (ejeMayor / 2) * (ejeMenor / 2);
    }

    public double calExcentricidad() {
        return Math.sqrt(1 - Math.pow(ejeMenor / 2, 2) / Math.pow(ejeMayor / 2, 2));
    }

    public double calPerimetro() {
        return Math.PI * (3 * (ejeMayor + ejeMenor) - Math.sqrt((Math.pow(ejeMayor, 2) + Math.pow(ejeMenor, 2)) / 2));
    }

    @Override
    public int compareTo(Elipse otro) {
        return Double.compare(this.calArea(), otro.calArea());
    }
}
