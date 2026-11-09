
import java.io.Serializable;

public class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return "Employee ID: " + id +
               "\nName: " + name +
               "\nDepartment: " + department +
               "\nSalary: " + salary;
    }
}
