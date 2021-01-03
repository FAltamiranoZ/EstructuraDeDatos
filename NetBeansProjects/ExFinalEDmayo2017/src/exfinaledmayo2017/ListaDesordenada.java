package exfinaledmayo2017;

import java.util.Iterator;

/**
 *
 * @author
 */
public class ListaDesordenada<T> implements Iterable<T> {

    private Nodo<T> primero;

    public ListaDesordenada() {
        primero = null;
    }

    //Método del problema 2. 
    public void cambiaOrden(T dato) {
        boolean resp = false;
        boolean out = false;
        boolean out2=false;
        Nodo<T> datoN = new Nodo<>(dato);
            Nodo<T> apuntador = primero;
            Nodo<T> apuntador2 = primero;
            Nodo<T> apuntador3 = primero;
            Nodo<T> apuntador4 = primero;
        if (contiene(dato)) {
            while (out2==false){//para ver si hay más de un dato
                
            while (apuntador != null && resp == false) {//para encontrar el dato
                resp = apuntador.getDato().equals(dato);
                if (resp == false) {
                    apuntador = apuntador.getSig();
                }
            }
            apuntador.getPrev().setSig(apuntador.getSig());//para eliminar el dato
            apuntador.getSig().setPrev(apuntador.getPrev());
            
            while (apuntador2.getSig() != null && out == false) {//para que apuntador 2 y 3 marquen el último
                if (apuntador2.getSig() == null) {
                    out = true;
                } else {
                    apuntador2 = apuntador2.getSig();
                    apuntador3 = apuntador3.getSig();
                }
            }
            
            while (apuntador3 != primero) {//para recorrer los datos a la derecha
                apuntador3=apuntador3.getPrev();
                apuntador2.setSig(apuntador2);
                apuntador2.setPrev(apuntador3);
                apuntador3.setSig(apuntador2);
                apuntador2 = apuntador3;
            }
            
            apuntador3.setSig(apuntador3);//para poner el dato hasta la izquierda
            apuntador3.setPrev(datoN);
            primero = datoN;
            primero.setSig(apuntador3);
            }
            if(apuntador4.getSig().getDato()==apuntador4.getDato()){
            apuntador4=apuntador4.getSig();
            }
            else{
                out2=true;
            }
        }
    }

    public void agregaFinal(T dato) {
        Nodo<T> nuevo = new Nodo(dato);
        if (isEmpty()) {
            primero = nuevo;
        } else {
            Nodo<T> apuntador = primero;
            while (apuntador.getSig() != null) {
                apuntador = apuntador.getSig();
            }
            apuntador.setSig(nuevo);
            nuevo.setPrev(apuntador);
        }
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public Iterator<T> iterator() {
        return new Iterador(primero);
    }

    @Override
    public String toString() {
        StringBuilder cad = new StringBuilder();
        Nodo<T> apuntador = primero;

        while (apuntador != null) {
            cad.append(apuntador.getDato()).append("  ");
            apuntador = apuntador.getSig();
        }
        return cad.toString();
    }

    public boolean contiene(T dato) {
        boolean resp = false;
        Nodo<T> apuntador = primero;

        while (apuntador != null && !resp) {
            resp = apuntador.getDato().equals(dato);
            apuntador = apuntador.getSig();
        }
        return resp;
    }

}
