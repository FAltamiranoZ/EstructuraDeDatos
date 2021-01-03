package jsjf;

import java.util.Iterator;
import java.util.Random;
import jsjf.exceptions.ElementNotFoundException;
import jsjf.exceptions.EmptyCollectionException;

/**
 *
 * @author edi
 */
public class HashSet<T> implements SetADT<T> {
    
    private UnorderedLinkedList<T> [] tabla;
    private int count, tamano;
    private final int INICIAL = 83; 
    private final Random R = new Random();
    private final double CARGA = .66;

    public HashSet() {
        clear();
    }
    
    public void clear(){
        this.tabla = new UnorderedLinkedList [INICIAL];
        this.count = 0;
        for(int i=0; i<INICIAL;i++){
            tabla[i] = new UnorderedLinkedList<>();
        }
        tamano = INICIAL;
    }
        
    public int size(){
        return count;
    }
    
    public boolean isEmpty(){
        return count==0;
    }
    
    private int indexOf(T elemento){
        return (elemento.hashCode() & 0x7FFFFFFF)%tamano;
    }
    
    public boolean contains(T elemento){
        return tabla[indexOf(elemento)].contains(elemento);
    }
    
    public void add(T elemento){
        if(!contains(elemento)){
            tabla[indexOf(elemento)].addLast(elemento);
            count++;
        }
        if(count/tamano >= CARGA)
            expandCapacity();
    }
    
    public T remove(T elemento){
        if(isEmpty()){
            throw new EmptyCollectionException("Hash Set");
        }
        else if(!contains(elemento)){
            throw new ElementNotFoundException("Hash Set");
        }else{
            count--;
            return tabla[indexOf(elemento)].remove(elemento);
        }
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tamano; i++)
            sb.append(tabla[i].toString());
        return sb.toString();
    }
    
    public boolean equals(SetADT<T> otro){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public T remove(){
        if(isEmpty())
            throw new EmptyCollectionException("Hash Set");
        int renglon = R.nextInt(tabla.length);
        while(tabla[renglon].isEmpty())
            renglon = (renglon + 1) % tabla.length;
        return tabla[renglon].removeLast();
    }
    
    private void expandCapacity(){
        int nuevoTamano = tamano*2;
        UnorderedLinkedList<T> [] nuevo = new UnorderedLinkedList [nuevoTamano];
        for(int i = 0; i < nuevo.length; i++){
            nuevo[i] = new UnorderedLinkedList();
        }
        Iterator<T> it = this.iterator();
        while(it.hasNext()){
            T elemento = it.next();
            nuevo[(elemento.hashCode() & 0x7FFFFFFF)%nuevoTamano].add(elemento);
        }
        tabla = nuevo;
    }
    
    public Iterator<T> iterator(){
        return new HashSetIterator(tabla, count);
    }
  
}
