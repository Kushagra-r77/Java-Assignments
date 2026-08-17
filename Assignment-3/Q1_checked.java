import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("data.txt");
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}
