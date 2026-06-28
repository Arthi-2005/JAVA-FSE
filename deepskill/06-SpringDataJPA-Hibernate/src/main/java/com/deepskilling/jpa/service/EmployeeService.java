package com.deepskilling.jpa.service;

import com.deepskilling.jpa.dto.DepartmentDTO;
import com.deepskilling.jpa.dto.EmployeeDTO;
import com.deepskilling.jpa.entity.Department;
import com.deepskilling.jpa.entity.Employee;
import com.deepskilling.jpa.exception.ResourceNotFoundException;
import com.deepskilling.jpa.repository.DepartmentRepository;
import com.deepskilling.jpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    private EmployeeDTO toDTO(Employee emp) {
        return EmployeeDTO.builder()
                .id(emp.getId())
                .name(emp.getName())
                .email(emp.getEmail())
                .salary(emp.getSalary())
                .departmentId(emp.getDepartment() != null ? emp.getDepartment().getId() : null)
                .departmentName(emp.getDepartment() != null ? emp.getDepartment().getName() : null)
                .build();
    }

    private DepartmentDTO toDTO(Department dept) {
        return DepartmentDTO.builder()
                .id(dept.getId())
                .name(dept.getName())
                .employeeCount(dept.getEmployees() != null ? dept.getEmployees().size() : 0)
                .build();
    }

    public EmployeeDTO createEmployee(String name, String email, Double salary, Long departmentId) {
        Department dept = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));

        Employee emp = Employee.builder()
                .name(name)
                .email(email)
                .salary(salary)
                .department(dept)
                .build();

        log.info("Creating employee: {}", name);
        return toDTO(employeeRepository.save(emp));
    }

    public EmployeeDTO getEmployee(Long id) {
        log.info("Fetching employee with id: {}", id);
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return toDTO(emp);
    }

    public List<EmployeeDTO> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeRepository.findAll().stream().map(this::toDTO).toList();
    }

    public EmployeeDTO updateEmployee(Long id, String name, String email, Double salary) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        emp.setName(name);
        emp.setEmail(email);
        emp.setSalary(salary);
        log.info("Updating employee: {}", id);
        return toDTO(employeeRepository.save(emp));
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        log.info("Deleting employee: {}", id);
        employeeRepository.deleteById(id);
    }

    public List<EmployeeDTO> getEmployeesByDepartment(Long deptId) {
        return employeeRepository.findByDepartmentId(deptId).stream().map(this::toDTO).toList();
    }

    public List<EmployeeDTO> searchByName(String name) {
        return employeeRepository.findByNameContaining(name).stream().map(this::toDTO).toList();
    }

    public List<EmployeeDTO> getHighEarners(Double minSalary) {
        return employeeRepository.findBySalaryGreaterThanEqual(minSalary).stream().map(this::toDTO).toList();
    }

    public Page<EmployeeDTO> getEmployeesPaged(int page, int size, String sortBy) {
        return employeeRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)))
                .map(this::toDTO);
    }

    public DepartmentDTO createDepartment(String name) {
        if (departmentRepository.existsByName(name)) {
            throw new ResourceNotFoundException("Department already exists: " + name);
        }
        Department dept = Department.builder().name(name).build();
        log.info("Creating department: {}", name);
        return toDTO(departmentRepository.save(dept));
    }

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream().map(this::toDTO).toList();
    }
}
