// JPA Relationships - How tables connect to each other

public class RelationshipsDemo {
    public static void main(String[] args) {
        System.out.println("=== JPA Relationships ===");
        System.out.println();

        System.out.println("1. @OneToOne");
        System.out.println("   One User has one Profile");
        System.out.println("   @OneToOne");
        System.out.println("   User -> Profile");
        System.out.println();

        System.out.println("2. @OneToMany / @ManyToOne (MOST COMMON)");
        System.out.println("   One Department has many Employees");
        System.out.println("   Employee belongs to one Department");
        System.out.println();
        System.out.println("   Department class:");
        System.out.println("     @OneToMany(mappedBy = \"department\")");
        System.out.println("     List<Employee> employees;");
        System.out.println();
        System.out.println("   Employee class:");
        System.out.println("     @ManyToOne");
        System.out.println("     @JoinColumn(name = \"department_id\")");
        System.out.println("     Department department;");
        System.out.println();

        System.out.println("3. @ManyToMany");
        System.out.println("   Student can enroll in many Courses");
        System.out.println("   Course can have many Students");
        System.out.println("   @ManyToMany");
        System.out.println("   Student <-> Course (join table)");
        System.out.println();

        System.out.println("Fetch Types:");
        System.out.println("  FetchType.LAZY  - Load when accessed (performance)");
        System.out.println("  FetchType.EAGER - Load immediately");
        System.out.println();

        System.out.println("Cascade Types:");
        System.out.println("  CascadeType.ALL - Save/Delete parent = same for child");
    }
}
