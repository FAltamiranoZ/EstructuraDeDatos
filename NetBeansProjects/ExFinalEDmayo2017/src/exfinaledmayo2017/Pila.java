package exfinaledmayo2017;

/**
 * 
 * @author 
 * @param <T> 
 */
public class Pila <T> implements PilaADT <T>{

    private T colec[];
    private int tope;
    private final int MAX = 10;

    public Pila() {
        colec = (T[]) (new Object[MAX]);
        tope = -1;
    }

    @Override
    public boolean isEmpty() {
        return tope == -1;
    }

    @Override
    public T peek() {
        T dato = null;
        if (!isEmpty())
            dato = colec[tope];
        return dato;
    }

    @Override
    public T pop() {
        T dato = null;
        if (!isEmpty()){
            dato = colec[tope];
            tope--;
        }
        return dato;
    }

    public void push(T dato) {
        if (colec.length == tope + 1)
            expandCapacity();
        tope++;
        colec[tope] = dato;
    }

    private void expandCapacity(){
        T nuevo[] = (T[]) (new Object[colec.length * 2]);
        int i;

        for (i = 0; i <= tope; i++)
            nuevo[i] = colec[i];
        colec = nuevo;
    }


}
