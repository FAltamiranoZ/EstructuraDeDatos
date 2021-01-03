package problema10;

/**
 *
 * @author Hagen
 */
public class DePasajeros extends Camion {

    private int totalPasaj;

    public DePasajeros(int totalPasaj, String marca, String numMotor, String placas) {
        super(marca, numMotor, placas);
        this.totalPasaj = totalPasaj;
    }

    @Override
    public String toString() {
        return super.toString() + "DePasajeros{" + "totalPasaj=" + totalPasaj + '}';
    }

}
