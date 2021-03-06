public class App {
    public static void main(String[] args)
    {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        dynamicArray.add(6);
        dynamicArray.add(7);
        dynamicArray.add(8);
        dynamicArray.add(9);
        dynamicArray.add(10);
        System.out.println(dynamicArray.toString());
        System.out.println(dynamicArray.size()); //10
        System.out.println(dynamicArray.getCapacity()); //16
        System.out.println(dynamicArray.remove(3));
        System.out.println(dynamicArray.size()); //9
        System.out.println(dynamicArray.getCapacity()); //9
        dynamicArray.add(17);
        System.out.println(dynamicArray.size()); //10
        System.out.println(dynamicArray.getCapacity()); //18
        System.out.println(dynamicArray.toString());
    }
}
