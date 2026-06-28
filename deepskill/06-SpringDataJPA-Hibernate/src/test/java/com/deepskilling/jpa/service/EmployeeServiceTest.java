package com.deepskilling.jpa.service;

import com.deepskilling.jpa.dto.EmployeeDTO;
import com.deepskilling.jpa.entity.Department;
import com.deepskilling.jpa.entity.Employee;
import com.deepskilling.jpa.exception.ResourceNotFoundException;
import com.deepskilling.jpa.repository.DepartmentRepository;
import com.deepskilling.jpa.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock private EmployeeRepository employeeRepository;
    @Mock private DepartmentRepository departmentRepository;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService(employeeRepository, departmentRepository);
    }

    @Test
    void createEmployee_shouldReturnDTO() {
        Department dept = Department.builder().id(1L).name("IT").build();
        Employee emp = Employee.builder().id(1L).name("John").email("john@test.com").salary(50000.0).department(dept).build();

        when(departmentRepository.findById(1L)).thenReturn(Optional.of(dept));
        when(employeeRepository.save(any())).thenReturn(emp);

        EmployeeDTO result = employeeService.createEmployee("John", "john@test.com", 50000.0, 1L);

        assertEquals("John", result.getName());
        assertEquals("IT", result.getDepartmentName());
        verify(employeeRepository).save(any());
    }

    @Test
    void createEmployee_shouldThrowWhenDepartmentNotFound() {
        when(departmentRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> employeeService.createEmployee("John", "john@test.com", 50000.0, 99L));
    }

    @Test
    void getEmployee_shouldThrowWhenNotFound() {
        when(employeeRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> employeeService.getEmployee(99L));
    }

    @Test
    void deleteEmployee_shouldThrowWhenNotFound() {
        when(employeeRepository.existsById(99L)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> employeeService.deleteEmployee(99L));
    }
}
