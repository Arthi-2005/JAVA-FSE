# Exercise 01 — Debug Basics

## Objectives

- Set breakpoints in Java code
- Step through code line by line
- Inspect variable values during execution

## Sample Code

Create a file `DebugDemo.java`:

```java
public class DebugDemo {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum = sum + i;
            System.out.println("i = " + i + ", sum = " + sum);
        }
        System.out.println("Final sum = " + sum);
    }
}
```

## Step-by-Step

### 1. Set a Breakpoint
- In Eclipse/VS Code, double-click the left margin on line 5 (`int sum = 0;`).
- A blue dot appears — this is your breakpoint.

### 2. Start Debugging
- **Eclipse:** Right-click → Debug As → Java Application.
- **VS Code:** Press F5.
- Execution pauses at the breakpoint.

### 3. Use Debug Controls
- **Step Over (F6 / F10):** Execute current line, move to next.
- **Step Into (F5 / F11):** Enter a method call.
- **Resume (F8 / F5):** Continue until next breakpoint.

### 4. Inspect Variables
- Look at the "Variables" view in Eclipse or "VARIABLES" pane in VS Code.
- Watch `i` and `sum` change as you step through the loop.

## Commands Summary

| Action | Eclipse | VS Code |
|--------|---------|---------|
| Toggle breakpoint | Ctrl+Shift+B | F9 |
| Start debug | Debug As → Java App | F5 |
| Step Over | F6 | F10 |
| Step Into | F5 | F11 |
| Step Return | F7 | Shift+F11 |
| Resume | F8 | F5 |

## Practice Tasks

1. Add a new variable `product = 1` and multiply it by `i` in the loop. Debug to verify.
2. Set a breakpoint inside the `if` condition if you add one.
3. Use "Step Into" on `System.out.println` to see what happens.
