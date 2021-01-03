
package exfinaledmayo2017;

/**
 *
 * @author 
 */
public class DeVolteo extends Camion{
    private double capacidadTon;

    public DeVolteo() {
        super();
    }

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
        StringBuilder cad = new StringBuilder();
        cad.append(super.toString());
        cad.append("\nCapacidad en toneladas: ").append(capacidadTon);
        return cad.toString();
    }    
}
