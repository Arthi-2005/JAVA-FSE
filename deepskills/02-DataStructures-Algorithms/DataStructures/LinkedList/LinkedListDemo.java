package DataStructures.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.display();
        System.out.println("Search 20: " + list.search(20));
        System.out.println("Search 50: " + list.search(50));
        list.delete(20);
        list.display();
        list.reverse();
        System.out.print("Reversed ");
        list.display();
    }
}
