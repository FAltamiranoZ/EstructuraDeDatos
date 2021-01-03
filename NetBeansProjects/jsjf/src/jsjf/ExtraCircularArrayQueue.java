package jsjf;

/**
 *
 * @author Hagen
 */
public class ExtraCircularArrayQueue<T> extends CircularArrayQueue<T> {

    public ExtraCircularArrayQueue() {
    }

    public <T> String CircularArrayQueueToString(CircularArrayQueue<T> col) {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty()) {
            int pos = first;
            while (pos != last - 1) {
                sb.append(queue[pos]).append(" ");
                //pos=(pos+1)%queue.length; Quite esto porque al usarlo en el reverse, me apuntaba a -1 al pasar del 0.
                pos = Math.floorMod(pos + 1, queue.length);
            }
            sb.append(queue[pos]);
        }
        return sb.toString();
    }

    public <T> String CircularArrayQueueToStringReverse(CircularArrayQueue<T> col) {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty()) {
            int pos = Math.floorMod(last - 1, queue.length);
            while (pos != first) {
                sb.append(queue[pos]).append(" ");
                pos = Math.floorMod(pos - 1, queue.length);
            }
            sb.append(queue[first]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExtraCircularArrayQueue<Integer> circular = new ExtraCircularArrayQueue<>();
        ExtraCircularArrayQueue<Integer> circular2 = new ExtraCircularArrayQueue<>();
        circular.add(1);
        circular.add(2);
        circular.add(3);
        circular.add(4);
        circular.add(5);
        circular.add(6);
        circular.add(7);
        circular.add(8);
        circular.add(9);
        System.out.println(circular.CircularArrayQueueToString(circular));
        circular2.add(1);
        circular2.add(2);
        circular2.add(3);
        circular2.add(4);
        circular2.add(5);
        circular2.add(6);
        circular2.add(7);
        circular2.add(8);
        circular2.add(9);
        System.out.println(circular.CircularArrayQueueToStringReverse(circular));
    }

}
