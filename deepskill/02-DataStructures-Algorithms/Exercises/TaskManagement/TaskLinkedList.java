package Exercises.TaskManagement;

public class TaskLinkedList {
    private TaskNode head;

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        System.out.println("Added task: " + task.getTaskName());
    }

    public Task searchTask(int id) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId() == id) return current.task;
            current = current.next;
        }
        return null;
    }

    public void traverse() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean deleteTask(int id) {
        if (head == null) return false;
        if (head.task.getTaskId() == id) {
            head = head.next;
            System.out.println("Deleted task " + id);
            return true;
        }
        TaskNode current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId() == id) {
                current.next = current.next.next;
                System.out.println("Deleted task " + id);
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
