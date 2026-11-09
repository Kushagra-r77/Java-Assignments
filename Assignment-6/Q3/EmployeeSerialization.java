
import java.io.*;

public class EmployeeSerialization {
    public static void main(String[] args) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("employees.dat")
            );

            oos.writeObject(new Employee(101, "Rahul", "IT", 50000));
            oos.writeObject(new Employee(102, "Aman", "HR", 45000));
            oos.writeObject(new Employee(103, "Rohan", "Finance", 60000));

            oos.close();

            System.out.println("Employee objects saved successfully.");

            ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("employees.dat")
            );

            System.out.println("\nEmployee Records:");

            while (true) {
                try {
                    Employee emp = (Employee) ois.readObject();
                    System.out.println("\n" + emp);
                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
