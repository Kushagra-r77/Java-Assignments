class AgeException extends Exception {
    AgeException(String message) {
        super(message);
    }
}
public class Main {
    public static void main(String[] args) {
        try {
            int age = 15;
            if (age < 18) {
                throw new AgeException("Age must be 18 or above");
            }
            System.out.println("Allowed");
        } catch (AgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
