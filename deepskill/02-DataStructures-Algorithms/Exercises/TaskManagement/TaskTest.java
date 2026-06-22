package Exercises.TaskManagement;

public class TaskTest {
    public static void main(String[] args) {
        TaskLinkedList list = new TaskLinkedList();
        list.addTask(new Task(1, "Design", "Pending"));
        list.addTask(new Task(2, "Develop", "In Progress"));
        list.addTask(new Task(3, "Test", "Pending"));
        System.out.println("--- All Tasks ---");
        list.traverse();
        System.out.println("--- Search ---");
        System.out.println(list.searchTask(2));
        System.out.println("--- Delete ---");
        list.deleteTask(1);
        list.traverse();
    }
}
