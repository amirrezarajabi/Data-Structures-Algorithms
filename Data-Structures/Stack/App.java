public class App {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.tostring(); // 1 2 3 4
        System.out.println(stack.pop()); // 4
        stack.tostring(); // 1 2 3
        System.out.println(stack.peek()); // 3
        stack.tostring(); // 1 2 3
        stack.pop(); // 3
        stack.pop(); // 2
        stack.pop(); // 1
        stack.pop(); // empty stack exception
    }
}
