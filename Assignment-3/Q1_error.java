public class Main {
    static void test() {
        test();
    }
    public static void main(String[] args) {
        try {
            test();
        } catch (StackOverflowError e) {
            System.out.println("Stack is full!");
        }
    }
}
