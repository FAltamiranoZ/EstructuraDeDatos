package figurasgeometricas;

public abstract class Poligono implements Figura2D {

    private int numLados;
    protected double[] lados;

    public Poligono(double[] a) {
        lados = a;
        numLados = a.length;
    }

    public void setLados(double[] lados) {
        this.lados = lados;
    }

    public int getNumLados() {
        return numLados;
    }

    public double calPerimetro() {
        double res = 0;
        for (int i = 0; i < numLados; i++) {
            res = res + lados[i]; //tambien se puede escribir como res+=lados[i]
        }
        return res;
    }

    public double ladoMasGrande() {
        int i;
        double res = lados[0];
        for (i = 0; i < lados.length; i++) {
            if (lados[i] < lados[i + 1]) {
                res = lados[i + 1];
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return "Poligono{" + "numLados=" + numLados + '}';
    }
}
