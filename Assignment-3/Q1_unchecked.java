class Main {
    public static void main(String[] args) {
        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[10]);
        } catch (Exception e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        } finally {
            System.out.println("\n");
        }
        try {
            int a = 10/0;
        } catch (Exception e) {
            System.out.println("ArithmeticError");
        } finally {
            System.out.println("\n");
        }
    }
}
