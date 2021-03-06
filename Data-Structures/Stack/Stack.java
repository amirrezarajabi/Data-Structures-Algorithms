import java.util.Iterator;
import java.util.LinkedList;

public class Stack <T> implements Iterable<T>{

    private LinkedList<T> list = new LinkedList<T>();

    public Stack() { }

    public Stack(T t){
        push(t);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T t){
        list.addLast(t);
    }

    public T pop(){
        if(isEmpty())
            throw new java.util.EmptyStackException();
        return list.removeLast();
    }

    public T peek(){
        if(isEmpty())
            return null;
        return list.peekLast();
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
