package figurasgeometricas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class POOload {

    public static void main(String[] args) {//Los 2 POO podrían hacerse en un solo main
        ArrayList<Figura2D> listaEntrada;
        try (FileInputStream fin = new FileInputStream("./archivoObjetos");
                ObjectInputStream ois = new ObjectInputStream(fin)) {
            listaEntrada = (ArrayList<Figura2D>) ois.readObject();
            FigurasGeometricas.procesamiento(listaEntrada);
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }

}
