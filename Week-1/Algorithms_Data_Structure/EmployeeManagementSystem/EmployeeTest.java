package EmployeeManagementSystem;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        // Add employees
        manager.addEmployee(new Employee(1, "Harini", "Developer", 50000));
        manager.addEmployee(new Employee(2, "Abinaya", "Manager", 65000));
        manager.addEmployee(new Employee(3, "Sathya", "Tester", 45000));

        // List all employees
        manager.listEmployees();

        // Search employee
        Employee e = manager.searchEmployee(2);
        System.out.println(e != null ? "Found: " + e : "Employee not found.");

        // Delete employee
        manager.deleteEmployee(2);

        // List again
        manager.listEmployees();
    }
}
