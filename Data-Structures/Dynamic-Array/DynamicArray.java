import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray <T> implements Iterable<T> {
    
    private T [] array;
    private int capacity;
    private int length;

    public DynamicArray(){
        this(8);
    }

    public DynamicArray(int capacity){
        this.capacity = capacity;
        array = (T[]) new Object[this.capacity];
        length = 0;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public T get(int index) {
        return array[index];
    }

    public void set(int index, T t){
        array[index] = t;
    }

    public void clear(){
        for (int i = 0; i < capacity; i++) {
            array[i] = null;
        }
        length = 0;
    }

    public void add(T t){
        if (length + 1 >= capacity){
            if (capacity == 0)
                capacity = 1;
            else
                capacity = capacity * 2;
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < length; i++)
                newArray[i] = array[i];
            array = newArray;
        }
        array[length++] = t;
    }

    public T removeAt(int index)
    {
        T objectToRemove = array[index];
        T[] newArray = (T[]) new Object[length - 1];
        for (int i = 0, j = 0; i < length; i++, j++){
            if (i == index)
                j--;
            else
                newArray[j] = array[i];
        }
        array = newArray;
        capacity = --length;
        return objectToRemove;
    }

    public boolean remove(Object obj){
        for (int i = 0; i< length; i++){
            if (array[i].equals(obj)){
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object obj){
        for (int i = 0; i < length; i++){
            if (array[i].equals(obj))
                return i;
        }
        return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj) == -1;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            int index = 0;
            @Override
            public boolean hasNext() { return index< length; }
            public T next(){ return array[index++]; }
        };
    }

    @Override
    public String toString() {
        if(length == 0)
            return "[]";
        else{
            StringBuilder sb = new StringBuilder(length).append("[");
            for (int i = 0; i < length - 1; i++)
                sb.append(array[i]+ ", ");
            return sb.append(array[length - 1]+ " ]").toString();
        }
    }
}
