package exfinaledmayo2017;

import java.util.Objects;

/**
 *
 * @author 
 */
public class Camion {
    private String marca, numMotor, placas;

    public Camion() {
    }

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
    public String toString() {
        return "\nCamion marca= " + marca + "  Placas= " + placas;        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.numMotor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Camion other = (Camion) obj;
        return this.numMotor.equals(other.numMotor);
    }
    
}
