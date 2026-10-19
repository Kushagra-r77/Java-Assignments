package courseportal.main;

import courseportal.model.Course;
import courseportal.service.RegistrationManager;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        RegistrationManager manager = new RegistrationManager();
        Course cs101 = new Course("CS101", "Intro to Programming", 2);
        cs101.addPrerequisite("MATH101");

        Course cs201 = new Course("CS201", "Data Structures", 1);
        cs201.addPrerequisite("CS101");

        manager.addCourse(cs101);
        manager.addCourse(cs201);

        Set<String> aliceCompleted = new HashSet<>();
        aliceCompleted.add("MATH101");

        Set<String> bobCompleted = new HashSet<>();
        bobCompleted.add("MATH101");
        bobCompleted.add("CS101");

        System.out.println("--- REGISTRATION PHASE ---");
        manager.registerStudent("Alice", "CS101", aliceCompleted);
        manager.registerStudent("Bob", "CS101", aliceCompleted); 
        manager.registerStudent("Charlie", "CS101", aliceCompleted);

        System.out.println("\n--- PREREQUISITE CHECK ---");
        manager.registerStudent("Alice", "CS201", aliceCompleted);

        manager.registerStudent("Bob", "CS201", bobCompleted);   

        System.out.println("\n--- DROP & WAITLIST PROMOTION TEST ---");
        manager.dropCourse("Alice", "CS101"); 
    }
}