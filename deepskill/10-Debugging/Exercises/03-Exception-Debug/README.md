# Exercise 03 — Exception Breakpoints

## Objectives

- Use exception breakpoints to catch errors immediately
- Debug try-catch blocks
- Identify the root cause of exceptions

## Sample Code

Create a file `ExceptionDebugDemo.java`:

```java
public class ExceptionDebugDemo {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", null, "Charlie"};
        
        for (int i = 0; i <= names.length; i++) {
            try {
                int length = names[i].length();
                System.out.println(names[i] + " has " + length + " characters.");
            } catch (NullPointerException e) {
                System.out.println("Null value at index " + i);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index " + i + " is out of bounds.");
            }
        }
    }
}
```

## Step-by-Step

### 1. Set an Exception Breakpoint
- In Eclipse: Run → Add Java Exception Breakpoint → NullPointerException.
- In VS Code: Add `"breakpoints": ["caughtExceptions", "uncaughtExceptions"]` to launch.json.
- Now the debugger stops whenever a NullPointerException is thrown.

### 2. Debug the Exception
- Run in debug mode.
- The debugger will stop at line 8 when `null.length()` is attempted.
- Inspect the stack trace and variable `i`.

### 3. Fix the Issue
- The loop condition `i <= names.length` causes an ArrayIndexOutOfBoundsException.
- Also, `names[2]` is null, causing NullPointerException.
- Fix by checking for null and using `i < names.length`.

## Practice Tasks

1. Add a try-catch for `ArithmeticException` and cause a division by zero.
2. Set an exception breakpoint for `ArithmeticException` and debug.
3. Write code that throws a custom exception and debug it with exception breakpoints.
