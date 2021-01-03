package exfinaledmayo2017;

/**
 * 
 * @author 
 */
public interface PilaADT <T>{
    public T pop();
    public T peek();
    public boolean isEmpty();
    public void push(T dato);
}
