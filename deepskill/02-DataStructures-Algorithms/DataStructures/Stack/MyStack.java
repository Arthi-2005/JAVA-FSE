package DataStructures.Stack;

public class MyStack {
    private int[] arr;
    private int top;
    private int capacity;

    public MyStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) { System.out.println("Stack Overflow"); return; }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) { System.out.println("Stack Underflow"); return -1; }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) return -1;
        return arr[top];
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull() { return top == capacity - 1; }
}
