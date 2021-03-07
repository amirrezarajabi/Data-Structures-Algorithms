import java.util.Iterator;
import java.util.LinkedList;

public class Queue <T> implements Iterable<T>{

    private LinkedList<T> list = new LinkedList<T>();

    public Queue() { }

    public Queue(T t){
        enQueue(t);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enQueue(T t){
        list.addLast(t);
    }


    public T peek(){
        if(isEmpty())
            return null;
        return list.peekFirst();
    }

    public T deQueue(){
        if(isEmpty())
            return null;
        return list.removeFirst();
    }


    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public void tostring() {
        for (T t: list)
            System.out.print(t.toString()+ " ");
        System.out.println();
    }
}
