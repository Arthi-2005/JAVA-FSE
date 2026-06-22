package Exercises.EcommerceSearch;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Phone", "Electronics"),
            new Product(3, "Book", "Education"),
            new Product(4, "Shoes", "Fashion")
        };

        int linearIdx = SearchService.linearSearch(products, "Book");
        System.out.println("Linear Search: Found at index " + linearIdx);

        int binaryIdx = SearchService.binarySearch(products, "Phone");
        System.out.println("Binary Search: Found at index " + binaryIdx);
    }
}
