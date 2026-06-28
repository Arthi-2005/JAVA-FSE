# Module 6: Spring Data JPA & Hibernate

**Status:** ✅ Successful

## Structure
```
06-SpringDataJPA-Hibernate/
├── pom.xml
├── src/main/java/com/deepskilling/jpa/
│   ├── JpaApplication.java
│   ├── entity/
│   │   ├── Department.java    # @Entity, @OneToMany
│   │   └── Employee.java      # @Entity, @ManyToOne
│   ├── repository/
│   │   ├── DepartmentRepository.java
│   │   └── EmployeeRepository.java
│   ├── service/EmployeeService.java
│   └── controller/EmployeeController.java
├── concepts/
│   ├── JPA/           -> JPADemo.java          # JPA basics
│   ├── Hibernate/     -> HibernateDemo.java     # Hibernate ORM
│   ├── SpringData/    -> SpringDataDemo.java    # Spring Data JPA
│   └── Relationships/ -> RelationshipsDemo.java # @OneToMany, @ManyToOne
└── screenshots/
```

## Concepts

| Concept | What it is |
|---------|-----------|
| **JPA** | Spec - map Java objects to DB tables (@Entity, @Id, @Column) |
| **Hibernate** | Implementation of JPA (auto-creates tables, lazy loading) |
| **Spring Data JPA** | Extend JpaRepository -> auto-implements CRUD + queries |
| **Relationships** | @OneToMany, @ManyToOne, @JoinColumn, FetchType, Cascade |

## Run
```bash
cd "06-SpringDataJPA-Hibernate"
mvn spring-boot:run
```
