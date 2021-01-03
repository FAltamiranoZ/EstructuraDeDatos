package problema10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Hagen
 */
public class EmpresaMinera implements Serializable { //Esto es para poder guardar el archivo en la misma clase.

    private String nombreEmpresa;
    private int totalCam; //Cuantos camiones hay, si se usa .length es el total de casillas.
    private Camion[] camiones;
    private static final int MAX = 20;

    public EmpresaMinera() {
        this("ACME", MAX);
    }

    public EmpresaMinera(String nombreEmpresa, int totalCam) {
        this.nombreEmpresa = nombreEmpresa;
        totalCam = 0;
        camiones = new Camion[totalCam];
    }

    public boolean agregaCamionPasajeros(int totalPasajeros, String marca, String numMotor, String placas) {
        boolean res = false;
        if (totalCam < camiones.length) {
            camiones[totalCam] = new DePasajeros(totalPasajeros, marca, numMotor, placas);
            totalCam++;
            res = true;
        }
        return res;
    }

    public boolean agregaCamionVolteo(double capacidad, String marca, String numMotor, String placas) {
        boolean res = false;
        if (totalCam < camiones.length) {
            camiones[totalCam] = new DeVolteo(capacidad, marca, numMotor, placas);
            totalCam++;
            res = true;
        }
        return res;
    }
//inciso 1

    public String datosCamionesPasajeros() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalCam; i++) {
            if (camiones[i] instanceof DePasajeros) {
                sb.append(camiones[i]);
            }
        }
        return sb.toString();
    }

    //inciso2
    public boolean setCapacidadTransporte(String placas, double capacidad) {
        boolean res = false;
        int i = 0;
        while (i < totalCam && !camiones[i].getPlacas().equals(placas)) {
            i++;
        }
        if (i == totalCam || camiones[i] instanceof DePasajeros) {
            res = false;
        } else {
            ((DeVolteo) camiones[i]).setCapacidadTon(capacidad);
            res = true;
        }
        return res;
    }

    //inciso3
    public int totalCamionesPconMarca(String marca) {
        int res = 0;
        for (int i = 0; i < totalCam; i++) {
            if (camiones[i] instanceof DePasajeros) {
                if (camiones[i].getMarca().equals(marca)) {
                    res++;
                }

            }
        }
        return res;
    }

    //inciso4
    public double totalToneladas() {
        double res = 0;
        for (int i = 0; i < totalCam; i++) {
            if (camiones[i] instanceof DeVolteo) {
                res += ((DeVolteo) camiones[i]).getCapacidadTon();
            }

        }
        return res;
    }

    //De aqui para abajo falta completar.
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmpresaMinera empresa = new EmpresaMinera("Empresa", 20);
        System.out.println(empresa.agregaCamionPasajeros(15, "KIA", "DL-44", "TKH-254"));
        System.out.println(empresa.agregaCamionPasajeros(30, "Nissan", "CA-87", "JYE-764"));
        System.out.println(empresa.agregaCamionVolteo(150, "Toyota", "A-280", "UHS-967"));
        System.out.println(empresa.agregaCamionVolteo(300, "Ferrari", "E-11", "HUS-634"));
        System.out.println(empresa.setCapacidadTransporte("Toyota", 24));
        System.out.println(empresa.totalCamionesPconMarca("KIA"));
        try (FileOutputStream fout = new FileOutputStream("./archivoObjetos");
                ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(empresa);
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        try (FileInputStream fin = new FileInputStream("./archivoObjetos");
                ObjectInputStream ois = new ObjectInputStream(fin)) {
            EmpresaMinera empresa2 = (EmpresaMinera) ois.readObject();
            System.out.println(empresa2.datosCamionesPasajeros());
            System.out.println(empresa2.totalToneladas());
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }

}
