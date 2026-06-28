package com.deepskilling.jpa.repository;

import com.deepskilling.jpa.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByNameContaining(String name);

    List<Employee> findBySalaryGreaterThanEqual(Double salary);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :min AND :max")
    List<Employee> findEmployeesBySalaryRange(@Param("min") Double min, @Param("max") Double max);

    @Query("SELECT e FROM Employee e JOIN FETCH e.department")
    List<Employee> findAllWithDepartment();

    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);

    long countByDepartmentId(Long departmentId);
}
