
package exfinaledmayo2017;

/**
 *
 * @author 
 */
public class DePasajeros extends Camion{
    private int totalPasaje;

    public DePasajeros() {
        super();
    }

    public DePasajeros(int totalPasaje, String marca, String numMotor, String placas) {
        super(marca, numMotor, placas);
        this.totalPasaje = totalPasaje;
    }

    public int getTotalPasaje() {
        return totalPasaje;
    }

    public void setTotalPasaje(int totalPasaje) {
        this.totalPasaje = totalPasaje;
    }

    @Override
    public String toString() {
        StringBuilder cad = new StringBuilder();
        cad.append(super.toString());
        cad.append("\nTotal de pasajeros: ").append(totalPasaje);
        return cad.toString();
    }
    
}
