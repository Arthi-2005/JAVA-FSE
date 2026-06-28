// Spring Data JPA = Makes JPA even easier
// Write INTERFACES only - Spring implements them automatically!

import java.util.List;

// Without Spring Data JPA (raw JPA):
// You need: EntityManager, persist(), find(), merge(), remove(), JPQL queries...

// With Spring Data JPA:
// JUST EXTEND JpaRepository - Spring auto-implements everything!
//
// interface EmployeeRepository extends JpaRepository<Employee, Long> {
//     List<Employee> findByName(String name);       // auto-SQL
//     List<Employee> findBySalaryGreaterThanEqual(Double salary);
//     List<Employee> findByNameContaining(String keyword);
// }
//
// Spring reads method names and writes SQL for you:
// findByName()              -> WHERE name = ?
// findBySalaryGreaterThan() -> WHERE salary >= ?
// findByNameContaining()    -> WHERE name LIKE %?%

public class SpringDataDemo {
    public static void main(String[] args) {
        System.out.println("=== Spring Data JPA ===");
        System.out.println();
        System.out.println("Traditional DAO: Write 100s of lines of code");
        System.out.println("Spring Data JPA: Just extend JpaRepository");
        System.out.println();
        System.out.println("Built-in methods:");
        System.out.println("  save(entity)       - Insert or Update");
        System.out.println("  findById(id)       - Get by primary key");
        System.out.println("  findAll()          - Get all records");
        System.out.println("  deleteById(id)     - Delete by ID");
        System.out.println("  count()            - Count records");
        System.out.println();
        System.out.println("Custom queries (auto-generated from name):");
        System.out.println("  findByEmail()           -> WHERE email = ?");
        System.out.println("  findByAgeBetween()      -> WHERE age BETWEEN ? AND ?");
        System.out.println("  findByNameOrderByAge()  -> ORDER BY age");
        System.out.println();
        System.out.println("JpaRepository<Employee, Long>");
        System.out.println("  Entity = Employee, ID type = Long");
    }
}
