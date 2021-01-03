package exfinaledmayo2017;
import java.util.Iterator;

/**
 *
 * @author 
 */
public class Empresa {
    private String nombre;
    private ListaDesordenada<Camion> lisCamiones;

    public Empresa() {
        lisCamiones = new ListaDesordenada();
    }

    public Empresa(String nombre) {
        this();
        this.nombre = nombre;
    }

    //Método del problema 3.
    public int incrementaPasajerosPorMarca(String marca, int incremento){
        int cambios =0;
        for(Camion elemento : lisCamiones){
        if(elemento instanceof DePasajeros){
            if(elemento.getMarca().equals(marca)){
            ((DePasajeros)elemento).setTotalPasaje(((DePasajeros)elemento).getTotalPasaje()+incremento);
            cambios++;
            }
        }
        }
        return cambios;
    }
   
    public boolean altaCamion(String marca, String numMotor, String placas, 
            int totalPasaje){
        DePasajeros nuevo = new DePasajeros(totalPasaje, marca, numMotor, 
                placas);
        boolean resp = false;
        
        if(!lisCamiones.contiene(nuevo)){
            resp = true;
            lisCamiones.agregaFinal(nuevo);
        }
        return resp;
    }
    
    public boolean altaCamion(String marca, String numMotor, String placas, 
            double capacidadTon){
        DeVolteo nuevo = new DeVolteo(capacidadTon, marca, numMotor, placas);
        boolean resp = false;
        
        if(!lisCamiones.contiene(nuevo)){
            resp = true;
            lisCamiones.agregaFinal(nuevo);
        }
        return resp;
    }
    
    public String generaReporteCamiones(){
        return lisCamiones.toString();
    }
    
}
