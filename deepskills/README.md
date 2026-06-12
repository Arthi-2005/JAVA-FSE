# Digital Nurture 5.0 - Deep Skilling Submission

**Student:** Arthi-2005
**Program:** Java FSE React

---

## Modules Covered

| # | Module | Description | Status |
|---|--------|-------------|--------|
| | **Engineering Concepts** | | |
| 1 | SOLID Principles & Design Patterns | SRP, OCP, LSP, ISP, DIP with individual class files; 9 GoF patterns (Creational/Structural/Behavioral) with separate demos & screenshots | ✅ Completed |
| 2 | Data Structures & Algorithms | `DataStructures/` (LinkedList, Stack, Queue, BinaryTree) + `Algorithms/` (Linear/Binary Search, Bubble/Insertion/Quick/Merge/Heap Sort) — each with demo + screenshot | ✅ Completed |
| | **Programming Languages** | | |
| 3 | PL/SQL Programming | `01-Basics` to `13-Triggers` — 13 individual SQL files with expected output screenshots | ✅ Completed |
| 4 | TDD, JUnit, Mockito, Lombok, SLF4J | `Calculator` + `UserService` with 13 JUnit 5 tests, Mockito mocks, Lombok `@Data` `@Builder` `@Slf4j` | ✅ Completed |
| | **Products & Frameworks** | |
| 5 | Spring Core & Maven | `MessageService` interface + `EmailService`/`SmsService` implementations + DI via `@Autowired` + component scan | 🚧 In Progress |
| 6 | Spring Data JPA & Hibernate | `Employee`/`Department` entities with `@OneToMany`/`@ManyToOne`, CRUD, pagination, custom queries | 🚧 In Progress |
| 6b | SonarQube Code Quality | Docker setup guide, `mvn sonar:sonar` analysis, quality gate configuration | ⏳ Not Started |
| 7 | Spring REST (Spring Boot 3) | `ProductController` with full CRUD, DTO, `@RestControllerAdvice` exception handling | ⏳ Not Started |
| 8 | Microservices (Spring Cloud) | Eureka registry + User/Order services + API Gateway — 4 demos (ServiceRegistry, APIGateway, CircuitBreaker, ConfigServer) | ⏳ Not Started |
| 9 | React SPA | Component-based UI, props, state, hooks, JSX explained with println demo | ⏳ Not Started |
| 10 | Application Debugging | Breakpoints, stack trace analysis, log debugging (TRACE/DEBUG/INFO/WARN/ERROR) | ⏳ Not Started |
| | **Platforms & Enablers** | |
| 11 | Git Version Control | Init, clone, add, commit, branch, merge, remote — all commands explained with demo | ⏳ Not Started |
| 12 | DevOps & CI/CD | GitHub Actions YAML pipeline with build/test/deploy stages + Jenkinsfile demo | ⏳ Not Started |
| 13 | Docker Containerization | Dockerfile, docker build/run, Docker Compose — full workflow in demo | ⏳ Not Started |
| 14 | Agile Methodology | Scrum roles, ceremonies (planning/standup/review/retro), user stories | ⏳ Not Started |
| 15 | Cloud Fundamentals (AWS) | EC2, S3, RDS, Lambda, VPC — service overview with deployment flow | ⏳ Not Started |
| 16 | Gen AI & GitHub Copilot | LLM concepts, prompt engineering, RAG, fine-tuning, Copilot-assisted coding | ⏳ Not Started |

---

## How to Run the Code

### Java Programs
```bash
# Module 1 - SOLID Principles
cd "01-SOLID-DesignPatterns/SOLID-Principles"
javac -sourcepath . -cp . SRP/SRPDemo.java && java -cp . SRP.SRPDemo
javac -sourcepath . -cp . OCP/OCPDemo.java && java -cp . OCP.OCPDemo
javac -sourcepath . -cp . LSP/LSPDemo.java && java -cp . LSP.LSPDemo
javac -sourcepath . -cp . ISP/ISPDemo.java && java -cp . ISP.ISPDemo
javac -sourcepath . -cp . DIP/DIPDemo.java && java -cp . DIP.DIPDemo

# Module 1 - Design Patterns
cd "../Design-Patterns"
javac -sourcepath . -cp . Creational/Singleton/SingletonDemo.java && java -cp . Creational.Singleton.SingletonDemo
javac -sourcepath . -cp . Creational/Factory/FactoryDemo.java && java -cp . Creational.Factory.FactoryDemo
javac -sourcepath . -cp . Creational/Builder/BuilderDemo.java && java -cp . Creational.Builder.BuilderDemo
javac -sourcepath . -cp . Structural/Adapter/AdapterDemo.java && java -cp . Structural.Adapter.AdapterDemo
javac -sourcepath . -cp . Structural/Decorator/DecoratorDemo.java && java -cp . Structural.Decorator.DecoratorDemo
javac -sourcepath . -cp . Structural/Proxy/ProxyDemo.java && java -cp . Structural.Proxy.ProxyDemo
javac -sourcepath . -cp . Behavioral/Observer/ObserverDemo.java && java -cp . Behavioral.Observer.ObserverDemo
javac -sourcepath . -cp . Behavioral/Strategy/StrategyDemo.java && java -cp . Behavioral.Strategy.StrategyDemo
javac -sourcepath . -cp . Behavioral/Command/CommandDemo.java && java -cp . Behavioral.Command.CommandDemo

# Module 2
javac DataStructures.java && java DataStructures
javac Algorithms.java && java Algorithms
```

### Maven Projects (Modules 4, 5, 6, 7, 8)
```bash
cd module-directory
mvn clean package
mvn test           # For Module 4 (TDD)
```

### React App (Module 9)
```bash
cd 09-React-SPA/my-app
npm install
npm start
```

### PL/SQL (Module 3)
Run in Oracle SQL Developer or any SQL client.
