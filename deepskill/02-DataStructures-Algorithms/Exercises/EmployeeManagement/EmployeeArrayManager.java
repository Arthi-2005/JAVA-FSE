package Exercises.EmployeeManagement;

import java.util.Arrays;

public class EmployeeArrayManager {
    private Employee[] employees;
    private int size;

    public EmployeeArrayManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee emp) {
        if (size < employees.length) {
            employees[size++] = emp;
            System.out.println("Added: " + emp.getName());
        } else {
            System.out.println("Array is full");
        }
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == id) return employees[i];
        }
        return null;
    }

    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == id) {
                employees[i] = employees[size - 1];
                employees[size - 1] = null;
                size--;
                System.out.println("Deleted employee " + id);
                return true;
            }
        }
        return false;
    }
}
