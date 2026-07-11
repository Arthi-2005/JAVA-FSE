# Exercise 02 — Conditional Breakpoints & Watch

## Objectives

- Set conditional breakpoints that trigger only when a condition is true
- Use watch expressions to evaluate custom expressions
- Debug specific scenarios efficiently

## Sample Code

Create a file `ConditionalDebugDemo.java`:

```java
public class ConditionalDebugDemo {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 70;
        
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Checking index " + i + ": " + numbers[i]);
            if (numbers[i] == target) {
                System.out.println("Found target at index " + i);
            }
        }
    }
}
```

## Step-by-Step

### 1. Set a Conditional Breakpoint
- Set a breakpoint on line 8 (`System.out.println("Checking...")`).
- Right-click the breakpoint → Breakpoint Properties.
- Add condition: `numbers[i] == 70`
- Now execution only pauses when the condition is met.

### 2. Add a Watch Expression
- In the debug perspective, find the "Expressions" or "Watch" view.
- Click "Add Watch Expression".
- Enter: `numbers[i] * 2`
- The value updates automatically as you step.

### 3. Debug with Condition
- Run in debug mode.
- Notice the loop runs without stopping until `i` reaches the index where `numbers[i] == 70`.

## Practice Tasks

1. Change the condition to break only when `i > 5`.
2. Add a watch expression for `numbers.length - i`.
3. Create a new array and use a conditional breakpoint to find the first element greater than 50.
