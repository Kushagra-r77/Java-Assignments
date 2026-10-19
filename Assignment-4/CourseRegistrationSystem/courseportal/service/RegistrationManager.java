package courseportal.service;

import courseportal.model.Course;
import java.util.HashMap;
import java.util.Set;

public class RegistrationManager {
    private HashMap<String, Course> courseMap = new HashMap<>();

    public void addCourse(Course course) {
        courseMap.put(course.getCourseCode(), course);
    }

    public boolean registerStudent(String studentId, String courseCode, Set<String> completedCourses) {
        Course course = courseMap.get(courseCode);
        if (course == null) {
            System.out.println("Error: Course " + courseCode + " does not exist.");
            return false;
        }
        for (String prereq : course.getPrerequisites()) {
            if (!completedCourses.contains(prereq)) {
                System.out.println("Registration Failed: Student " + studentId + " is missing prerequisite -> " + prereq);
                return false;
            }
        }
        if (course.getEnrolledStudents().contains(studentId) || course.getWaitlist().contains(studentId)) {
            System.out.println("Notice: Student " + studentId + " is already enrolled or in the waitlist for " + courseCode);
            return false;
        }
        if (course.getEnrolledStudents().size() < course.getCapacity()) {
            course.getEnrolledStudents().add(studentId);
            System.out.println("Success: Student " + studentId + " enrolled in " + courseCode);
            return true;
        } else {
            course.getWaitlist().add(studentId);
            System.out.println("Capacity full: Student " + studentId + " added to the waitlist for " + courseCode);
            return false;
        }
    }
    public void dropCourse(String studentId, String courseCode) {
        Course course = courseMap.get(courseCode);
        if (course == null) return;

        if (course.getEnrolledStudents().remove(studentId)) {
            System.out.println("Student " + studentId + " successfully dropped " + courseCode);
            if (!course.getWaitlist().isEmpty()) {
                String promotedStudent = course.getWaitlist().poll();
                course.getEnrolledStudents().add(promotedStudent);
                System.out.println("Automated Promotion: Student " + promotedStudent + " promoted from waitlist to enrolled in " + courseCode);
            }
        } else if (course.getWaitlist().remove(studentId)) {
            System.out.println("Student " + studentId + " removed from the waitlist of " + courseCode);
        } else {
            System.out.println("Student " + studentId + " was not found in " + courseCode);
        }
    }
}