import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void clear() {
        Node<T> iter = head;
        while (iter != null) {
            Node<T> next = iter.next;
            iter.next = null;
            iter.data = null;
            iter = next;
        }
        head = tail = iter = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public void addLast(T t) {
        if (isEmpty()) {
            head = tail = new Node<T>(t, null);
        } else {
            tail.next = new Node<T>(t, null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T t) {
        if (isEmpty()) {
            head = tail = new Node<T>(t, null);
        } else {

            Node<T> h = new Node<T>(t, head);
            head = h;
            h = null;
        }
        size++;
    }

    public void addByIndex(int index, T data) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Invalid index!");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node<T> iter = head;
        for (int i = 0; i < index - 1; i++) {
            iter = iter.next;
        }
        Node<T> newNode = new Node<>(data, iter.next);
        iter.next = newNode;
        size++;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list!");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty list!");
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list!");
        T data = head.data;
        head = head.next;
        size--;
        if (isEmpty())
            tail = null;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty list!");
        Node<T> iter = head;
        Node<T> l = head;
        while(iter.next != null) {
            l = iter;
            iter = iter.next;
        }
        T data = tail.data;
        tail = l;
        size--;
        if (isEmpty())
            head = null;
        else
            tail.next = null;
        return data;
    }

    private T remove(Node<T> node) {
        if (node.data.equals(head.data))
            return removeFirst();
        if (node.next == null)
            return removeLast();
        Node<T> iter = head;
        while (!iter.next.data.equals(node.data))
            iter = iter.next;
        iter.next = node.next;
        T data = node.data;
        node.data = null;
        node = node.next = null;
        size--;
        return data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index!");
        }
        int i;
        Node<T> iter;
        for (i = 0, iter = head; i != index; i++) {
            iter = iter.next;
        }
        return remove(iter);
    }

    public boolean remove(Object obj) {
        Node<T> iter = head;
        if (obj == null) {
            for (iter = head; iter != null; iter = iter.next) {
                if (iter.data == null) {
                    remove(iter);
                    return true;
                }
            }
        }
        else {
            for (iter = head; iter != null; iter = iter.next) {
                if (obj.equals(iter.data)) {
                    remove(iter);
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(Object obj) {
        int index = 0;
        Node<T> iter = head;

        if (obj == null) {
            for (iter = head; iter != null; iter = iter.next, index++) {
                if (iter.data == null) {
                    return index;
                }
            }
        } else
            for (iter = head; iter != null; iter = iter.next, index++) {
                if (obj.equals(iter.data)) {
                    return index;
                }
            }

        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data);
            if (trav.next != null) {
                sb.append(" > ");
            }
            trav = trav.next;
        }
        sb.append("> ]");
        return sb.toString();
    }
}