package Assignment4;
import java.util.Scanner;
class Q1{
    public static void main(String[] args) {

        // ArithmeticException
        try {
            int a = 10 / 0;
        }
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException occurred");
        }

        // NullPointerException
        try {
            String name = null;
            System.out.println(name.length());
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException occurred");
        }

        // ArrayIndexOutOfBoundsException
        try {
            int[] arr = {10, 20, 30};
            System.out.println(arr[5]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException occurred");
        }

        // NumberFormatException
        try {
            String s = "abc";
            int n = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred");
        }
    }
}