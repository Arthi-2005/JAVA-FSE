# Exercise 04 — Multi-threaded Debugging

## Objectives

- Debug multi-threaded Java applications
- Switch between threads in the debugger
- Identify race conditions and deadlocks

## Sample Code

Create a file `MultithreadDebugDemo.java`:

```java
public class MultithreadDebugDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }, "Thread-1");
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }, "Thread-2");
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final count: " + counter.getCount());
    }
}

class Counter {
    private int count = 0;
    
    public void increment() {
        count++; // This is not thread-safe!
    }
    
    public int getCount() {
        return count;
    }
}
```

## Step-by-Step

### 1. Set Breakpoints
- Set a breakpoint on line 27 (`count++;`).
- Also set one on line 37 (`System.out.println("Final count...")`).

### 2. Debug Multi-threaded
- Run in debug mode.
- When the breakpoint hits, look at the "Debug" view.
- You'll see two threads: Thread-1 and Thread-2.
- **Switch threads** by clicking on each thread in the Debug view.

### 3. Observe Race Condition
- The `count++` operation is not synchronized.
- Both threads can read/write `count` at the same time.
- The final count may NOT be 2000 (expected) — it can be less.

### 4. Fix with Synchronization
- Add `synchronized` keyword to the increment method:
  ```java
  public synchronized void increment() {
      count++;
  }
  ```
- Debug again — now the final count should always be 2000.

## Practice Tasks

1. Add a third thread and observe thread switching.
2. Remove `synchronized` and run multiple times to see the race condition.
3. Use a `ReentrantLock` instead of `synchronized`.
