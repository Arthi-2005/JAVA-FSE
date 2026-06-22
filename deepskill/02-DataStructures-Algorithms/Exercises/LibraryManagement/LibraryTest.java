package Exercises.LibraryManagement;

public class LibraryTest {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Java Programming", "James Gosling"),
            new Book(2, "Data Structures", "Mark Weiss"),
            new Book(3, "Algorithms", "Robert Sedgewick"),
            new Book(4, "Design Patterns", "Gang of Four")
        };

        int linearIdx = LibrarySearch.linearSearch(books, "Algorithms");
        System.out.println("Linear Search: '" + books[linearIdx].getTitle() + "' at index " + linearIdx);

        int binaryIdx = LibrarySearch.binarySearch(books, "Design Patterns");
        System.out.println("Binary Search: '" + books[binaryIdx].getTitle() + "' at index " + binaryIdx);
    }
}
