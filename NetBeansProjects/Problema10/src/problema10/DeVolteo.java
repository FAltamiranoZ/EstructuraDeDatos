package problema10;

/**
 *
 * @author Hagen
 */
public class DeVolteo extends Camion {

    private double capacidadTon;

    public DeVolteo(double capacidadTon, String marca, String numMotor, String placas) {
        super(marca, numMotor, placas);
        this.capacidadTon = capacidadTon;
    }

    public double getCapacidadTon() {
        return capacidadTon;
    }

    public void setCapacidadTon(double capacidadTon) {
        this.capacidadTon = capacidadTon;
    }

    @Override
    public String toString() {
        return super.toString() + "DeVolteo{" + "capacidadTon=" + capacidadTon + '}';
    }

}
