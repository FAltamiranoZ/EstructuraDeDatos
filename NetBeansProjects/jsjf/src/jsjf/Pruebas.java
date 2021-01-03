/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsjf;

/**
 *
 * @author polup_000
 */
public class Pruebas<T> extends ExtraCircularArrayQueue {

    /**
     * @param args the command line arguments
     */
    public static String toStringi(){
        StringBuilder sb=new StringBuilder();
        sb.append("1234");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        ExtraCircularArrayQueue<Integer> hey = new ExtraCircularArrayQueue<>();
        hey.add(1);
        System.out.println(10 % 6);
        System.out.println(hey.CircularArrayQueueToString(hey));
        if (hey instanceof ExtraCircularArrayQueue) {
            System.out.println("10");
        } else {
            System.out.println("100");
        }
        System.out.println(toStringi());
    }

}
