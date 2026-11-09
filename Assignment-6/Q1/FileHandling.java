
import java.io.*;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Student Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Student Marks: ");
            double marks = sc.nextDouble();
            sc.nextLine();

            try (FileWriter fw = new FileWriter("students.txt")) {
                fw.write("Student ID: " + id + "\n");
                fw.write("Student Name: " + name + "\n");
                fw.write("Course: " + course + "\n");
                fw.write("Marks: " + marks + "\n");
            }

            System.out.println("\nStudent Details from File:");

            try (FileReader fr = new FileReader("students.txt")) {
                int ch;

                while ((ch = fr.read()) != -1) {
                    System.out.print((char) ch);
                }
            }

            System.out.print("\nEnter the name of a binary file to copy: ");
            String source = sc.nextLine();

            try (
                FileInputStream fis = new FileInputStream(source);
                FileOutputStream fos = new FileOutputStream("copied_file.dat")
            ) {
                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("Binary file copied successfully.");

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
