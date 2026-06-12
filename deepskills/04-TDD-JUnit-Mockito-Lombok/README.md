# Module 4: TDD - JUnit, Mockito, Lombok, SLF4J

**Status:** ✅ Successful

---

## Structure

```
04-TDD-JUnit-Mockito-Lombok/
├── pom.xml                          # Maven dependencies
├── src/main/java/com/deepskilling/
│   ├── Calculator.java              # Simple calculator (@Slf4j)
│   └── UserService.java            # User CRUD + User model + UserRepository
├── src/main/resources/logback.xml   # Logging config
└── src/test/java/com/deepskilling/
    ├── CalculatorTest.java          # 7 JUnit tests for Calculator
    └── UserServiceTest.java         # 6 Mockito tests for UserService
```

---

## Concepts Covered

### 1. TDD (Test Driven Development)

**What it is:** Write tests FIRST, then write code to make them pass.

**Cycle:** **Red** (write failing test) → **Green** (write minimal code to pass) → **Refactor** (clean up code)

**In our code:**
- `Calculator` methods were implemented based on test expectations
- All edge cases (division by zero, negative numbers) handled after tests defined them

---

### 2. JUnit 5

**What it is:** Java's standard unit testing framework.

| Annotation | Purpose | Used In |
|-----------|---------|---------|
| `@Test` | Marks a test method | CalculatorTest, UserServiceTest |
| `@DisplayName` | Human-readable test name | Both test classes |
| `@BeforeEach` | Runs before each test | `setUp()` in both |
| `@ExtendWith` | Registers extensions | UserServiceTest → MockitoExtension |

**Assertions used:**
```java
assertEquals(expected, actual)     // Check equality
assertTrue(condition)              // Check boolean true
assertFalse(condition)             // Check boolean false
assertThrows(Exception, () -> ...) // Check exception thrown
assertAll(() -> ..., () -> ...)    // Group multiple assertions
```

---

### 3. Mockito

**What it is:** Framework for creating mock objects in tests.

**Why?** When testing `UserService`, we don't want a real database — we mock `UserRepository`.

| Mockito Feature | Annotation/Method | What it does |
|----------------|-------------------|-------------|
| Create mock | `@Mock` | Creates fake `UserRepository` |
| Inject mock | `@InjectMocks` | Injects mock into `UserService` |
| Stub method | `when(repo.findById(1L)).thenReturn(user)` | Returns user when called |
| Verify call | `verify(repo, times(1)).findById(1L)` | Ensures method was called once |
| Any matcher | `any(User.class)`, `anyLong()` | Matches any argument |

**Example:**
```java
@Mock
private UserRepository userRepository;

@InjectMocks
private UserService userService;

@Test
void testGetUserById_Success() {
    when(userRepository.findById(1L)).thenReturn(testUser);
    User result = userService.getUserById(1L);
    assertEquals("John Doe", result.getName());
    verify(userRepository, times(1)).findById(1L);
}
```

---

### 4. Lombok

**What it is:** Library that reduces boilerplate code via annotations.

| Annotation | What it generates | Used On |
|-----------|------------------|---------|
| `@Data` | Getter, Setter, ToString, EqualsAndHashCode, RequiredArgsConstructor | `User` |
| `@Builder` | Builder pattern (`User.builder().name(...).build()`) | `User` |
| `@NoArgsConstructor` | No-arg constructor | `User` |
| `@AllArgsConstructor` | Constructor with all args | `User` |
| `@Slf4j` | Logger field (`log.info(...)`) | `Calculator`, `UserService` |

**Without Lombok** — To write `User` class manually:
```java
public class User {
    private Long id;
    private String name;
    private String email;
    private int age;
    // Getters + Setters + toString + equals + hashCode + constructors
    // ~60 lines of boilerplate
}
```

**With Lombok (`@Data @Builder @NoArgsConstructor @AllArgsConstructor`):**
```java
// Just the fields — generates everything automatically!
```

---

### 5. SLF4J + Logback

**What it is:** Logging framework.

**Log levels:** `DEBUG < INFO < WARN < ERROR`

| Level | Message | Example |
|-------|---------|---------|
| `DEBUG` | Detailed info | `"Adding 2 + 3"` |
| `INFO` | Normal flow | `"Fetching user with id: 1"` |
| `WARN` | Something unusual | `"User not found with id: 99"` |
| `ERROR` | Failure | `"Division by zero attempted"` |

**@Slf4j** annotation auto-creates a `log` field:
```java
log.debug("Adding {} + {}", a, b);  // → "Adding 2 + 3"
log.error("Division by zero");       // → logs ERROR level
```

---

## Calculator Tests (7 tests)

| Test | What it checks |
|------|---------------|
| `testAdd()` | 2+3=5, 7+3=10, -1+1=0 |
| `testSubtract()` | 5-2=3, 2-3=-1, 5-5=0 |
| `testMultiply()` | 2*3=6, 0*5=0, -2*3=-6 |
| `testDivide()` | 6/3=2, 9/3=3 |
| `testDivideByZero()` | **Edge case:** 5/0 → throws ArithmeticException |
| `testIsEven()` | 2=true, 0=true, 3=false, -1=false |
| `testMultipleAdditions()` | assertAll groups 3 assertions |

## UserService Tests (6 tests)

| Test | What it checks |
|------|---------------|
| `testGetUserById_Success()` | Mock repo returns user → name = "John Doe" |
| `testGetUserById_NotFound()` | Mock returns null → throws NoSuchElementException |
| `testCreateUser()` | Mock save → returns user with ID=2 |
| `testDeleteUser()` | Mock delete → verify method called once |
| `testGetAllUsers()` | Mock findAll → returns list size 2 |
| `testWithArgumentMatchers()` | anyLong() matcher → works with any ID |

---

## Run

```bash
cd "04-TDD-JUnit-Mockito-Lombok"
mvn clean test
```

**Expected output:** `Tests run: 13, Failures: 0, Errors: 0`
