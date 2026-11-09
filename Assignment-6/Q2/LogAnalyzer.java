
import java.io.*;

public class LogAnalyzer {
    public static void main(String[] args) {
        int total = 0;
        int errors = 0;
        int warnings = 0;

        try (
            BufferedReader br = new BufferedReader(new FileReader("app.log"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("filtered.log"))
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                total++;

                if (line.toUpperCase().contains("ERROR")) {
                    errors++;
                    bw.write(line);
                    bw.newLine();
                } else if (line.toUpperCase().contains("WARNING")) {
                    warnings++;
                    bw.write(line);
                    bw.newLine();
                }
            }

            System.out.println("Total Log Entries: " + total);
            System.out.println("Total Errors: " + errors);
            System.out.println("Total Warnings: " + warnings);
            System.out.println("Filtered logs saved successfully.");

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
