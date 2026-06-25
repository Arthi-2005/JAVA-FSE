# Module 5: Spring Core & Maven (IoC, DI, AOP)

**Status:** ✅ Successful

---

## Structure

```
05-Spring-Core-Maven/
├── pom.xml
├── src/main/java/com/deepskilling/spring/
│   ├── MessageService.java       # Interface
│   ├── EmailService.java         # @Service impl
│   ├── SmsService.java           # @Service impl
│   ├── AppConfig.java            # @Configuration + @ComponentScan
│   ├── NotificationClient.java   # @Component with @Autowired
│   └── MainApp.java              # Runs the app
├── concepts/
│   ├── IoC/    → IoCDemo.java    # Inversion of Control explained
│   ├── DI/     → DIDemo.java     # Dependency Injection explained
│   ├── AOP/    → AOPDemo.java    # Aspect Oriented Programming
│   └── Maven/  → MavenDemo.java  # Maven build tool basics
└── screenshots/
```

---

## Concepts

### IoC (Inversion of Control)
| Before Spring | With Spring |
|--------------|-------------|
| You create objects with `new` | Spring creates & manages objects |
| You control lifecycle | Spring Container controls lifecycle |
| Tight coupling | Loose coupling |

### DI (Dependency Injection)
Types:
1. **Constructor Injection** (best) — dependencies via constructor
2. **Setter Injection** — via setter methods
3. **Field Injection** — via `@Autowired` on field

### AOP (Aspect Oriented Programming)
Cross-cutting concerns (logging, security, transactions) moved to one place:
- `@Before` — before method execution
- `@After` — after method execution
- `@Around` — wraps the method

---

## Existing Code Flow

```
MainApp
  ↓ creates
AnnotationConfigApplicationContext(AppConfig)
  ↓ @ComponentScan finds
NotificationClient  → has @Autowired EmailService (MessageService impl)
  ↓ calls
MessageService.getMessage() → "Email sent successfully!"
```

## Run
```bash
cd "05-Spring-Core-Maven"
mvn compile exec:java
```
