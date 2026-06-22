package Exercises.EmployeeManagement;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeArrayManager mgr = new EmployeeArrayManager(10);
        mgr.addEmployee(new Employee(1, "John", "Developer", 60000));
        mgr.addEmployee(new Employee(2, "Jane", "Manager", 80000));
        mgr.addEmployee(new Employee(3, "Bob", "Analyst", 50000));
        System.out.println("--- All Employees ---");
        mgr.traverse();
        System.out.println("--- Search ---");
        System.out.println(mgr.searchEmployee(2));
        System.out.println("--- Delete ---");
        mgr.deleteEmployee(1);
        mgr.traverse();
    }
}
