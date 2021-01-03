package figurasgeometricas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class POOsave {

    public static void main(String[] args) {
        ArrayList<Figura2D> listaSalida = FigurasGeometricas.creacion();
        try (FileOutputStream fout = new FileOutputStream("./archivoObjetos");
                ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(listaSalida);
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
