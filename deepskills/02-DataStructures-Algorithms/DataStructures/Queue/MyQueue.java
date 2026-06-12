package DataStructures.Queue;

public class MyQueue {
    private int[] arr;
    private int front, rear, capacity;

    public MyQueue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
    }

    public void enqueue(int x) {
        if (rear == capacity - 1) { System.out.println("Queue Full"); return; }
        arr[++rear] = x;
    }

    public int dequeue() {
        if (front > rear) { System.out.println("Queue Empty"); return -1; }
        return arr[front++];
    }

    public void display() {
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }
}
