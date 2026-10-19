public class Q1 {
    public static <T extends Number> double calculateSum(T[] array) {
        double sum = 0.0;
        for (T element : array) {
            sum += element.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        Integer[] intArray = {10, 20, 30, 40, 50};
        Float[] floatArray = {1.5f, 2.5f, 3.5f};
        Double[] doubleArray = {10.5, 20.1, 30.4};

        System.out.println("Sum of Integer Array: " + calculateSum(intArray));
        System.out.println("Sum of Float Array: " + calculateSum(floatArray));
        System.out.println("Sum of Double Array: " + calculateSum(doubleArray));
    }
}