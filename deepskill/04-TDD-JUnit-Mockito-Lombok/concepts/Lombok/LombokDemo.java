// Lombok = Reduces boilerplate code
// @Data = Getter + Setter + ToString + EqualsAndHashCode
// @Builder = Builder pattern
// @NoArgsConstructor = no-arg constructor
// @AllArgsConstructor = constructor with all args
// @Slf4j = Logger

import lombok.*;

// Without Lombok, this would be ~50 lines of getters/setters/constructors
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Student {
    private int id;
    private String name;
    private String course;
}

// @Slf4j creates a 'log' object automatically
@Slf4j
public class LombokDemo {
    public static void main(String[] args) {
        // Using @Builder - clean object creation
        Student s1 = Student.builder()
                .id(1)
                .name("Ram")
                .course("Java")
                .build();

        // Using @NoArgsConstructor + setters
        Student s2 = new Student();
        s2.setId(2);
        s2.setName("Sam");
        s2.setCourse("React");

        // Using @AllArgsConstructor
        Student s3 = new Student(3, "Raj", "AWS");

        // Using @Data generated getters
        System.out.println("Student 1: " + s1.getId() + " - " + s1.getName() + " - " + s1.getCourse());
        System.out.println("Student 2: " + s2);
        System.out.println("Student 3: " + s3);

        // Using @Slf4j logger
        log.info("Total students created: 3");
        log.debug("Student details: {}", s1);
    }
}
