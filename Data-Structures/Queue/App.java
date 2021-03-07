public class App {
    public static void main(String[] args)
    {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.tostring(); // 1 2 3 4
        System.out.println(queue.peek()); // 1
        queue.tostring(); // 1 2 3 4
        System.out.println(queue.deQueue()); // 1
        queue.tostring(); // 2 3 4
    }
}
