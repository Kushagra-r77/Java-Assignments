package library.main;

import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;
import library.service.Printable;
import library.util.InputValidator;

public class Main {
    public static void main(String[] args) {
        LibraryResource[] resources = new LibraryResource[5];
        
        resources[0] = new Book(101, "Java Programming", "James Gosling");
        resources[1] = new DigitalResource(102, "Data Science Basics", "Andrew Ng");
        resources[2] = new Book(103, "Clean Code", "Robert C. Martin");
        resources[3] = new DigitalResource(104, "Design Patterns", "Gang of Four");
        resources[4] = new Book(105, "Database Systems", "C.J. Date");

        // Simulated overdue days for testing
        int[] overdueDays = {2, 0, 5, 10, 0}; 
        double totalFine = 0.0;

        System.out.println("=== " + LibraryResource.getLibraryName() + " ===");
        
        for (int i = 0; i < resources.length; i++) {
            LibraryResource res = resources[i];
            int days = overdueDays[i];
            
            if (InputValidator.validateResourceId(res.getResourceId()) && InputValidator.validateFineDays(days)) {
                if (res instanceof Printable) {
                    ((Printable) res).printDetails();
                }
                
                double fine = res.calculateFine(days);
                System.out.println("-> Overdue Days: " + days + " | Fine: Rs. " + fine + "\n");
                totalFine += fine;
            } else {
                System.out.println("Invalid data found for Resource ID: " + res.getResourceId());
            }
        }
        
        System.out.println("-----------------------------------");
        System.out.println("Total Fine Collected: Rs. " + totalFine);
        LibraryResource.displayTotalResources();
    }
}