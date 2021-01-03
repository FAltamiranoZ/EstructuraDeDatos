package problema10;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Hagen
 */
public abstract class Camion implements Serializable {

    private final String marca, numMotor, placas;

    public Camion(String marca, String numMotor, String placas) {
        this.marca = marca;
        this.numMotor = numMotor;
        this.placas = placas;
    }

    public String getMarca() {
        return marca;
    }

    public String getNumMotor() {
        return numMotor;
    }

    public String getPlacas() {
        return placas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.placas);
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
        final Camion other = (Camion) obj;
        if (!Objects.equals(this.placas, other.placas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Camion{" + "marca=" + marca + ", numMotor=" + numMotor + ", placas=" + placas + '}';
    }

}
