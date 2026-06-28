package com.deepskilling.jpa.controller;

import com.deepskilling.jpa.dto.DepartmentDTO;
import com.deepskilling.jpa.dto.EmployeeDTO;
import com.deepskilling.jpa.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/departments")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.createDepartment(name));
    }

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(employeeService.getAllDepartments());
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> createEmployee(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam Double salary,
            @RequestParam Long departmentId) {
        return ResponseEntity.ok(employeeService.createEmployee(name, email, salary, departmentId));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam Double salary) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, name, email, salary));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/employees/search")
    public ResponseEntity<List<EmployeeDTO>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.searchByName(name));
    }

    @GetMapping("/employees/high-earners")
    public ResponseEntity<List<EmployeeDTO>> getHighEarners(@RequestParam Double minSalary) {
        return ResponseEntity.ok(employeeService.getHighEarners(minSalary));
    }

    @GetMapping("/employees/department/{deptId}")
    public ResponseEntity<List<EmployeeDTO>> getByDepartment(@PathVariable Long deptId) {
        return ResponseEntity.ok(employeeService.getEmployeesByDepartment(deptId));
    }

    @GetMapping("/employees/paged")
    public ResponseEntity<Page<EmployeeDTO>> getEmployeesPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(employeeService.getEmployeesPaged(page, size, sortBy));
    }
}
