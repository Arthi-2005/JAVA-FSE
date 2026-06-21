package Algorithms.Sorting;

import java.util.Arrays;

public class SortingDemo {
    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

        int[] a1 = arr.clone(); BubbleSort.sort(a1); System.out.println("Bubble Sort: " + Arrays.toString(a1));
        int[] a2 = arr.clone(); InsertionSort.sort(a2); System.out.println("Insertion Sort: " + Arrays.toString(a2));
        int[] a3 = arr.clone(); QuickSort.sort(a3, 0, a3.length - 1); System.out.println("Quick Sort: " + Arrays.toString(a3));
        int[] a4 = arr.clone(); MergeSort.sort(a4, 0, a4.length - 1); System.out.println("Merge Sort: " + Arrays.toString(a4));
        int[] a5 = arr.clone(); HeapSort.sort(a5); System.out.println("Heap Sort: " + Arrays.toString(a5));

        System.out.println("\nAlgorithm       | Best      | Average   | Worst");
        System.out.println("Bubble Sort     | O(n)      | O(n^2)    | O(n^2)");
        System.out.println("Insertion Sort  | O(n)      | O(n^2)    | O(n^2)");
        System.out.println("Quick Sort      | O(n log n)| O(n log n)| O(n^2)");
        System.out.println("Merge Sort      | O(n log n)| O(n log n)| O(n log n)");
        System.out.println("Heap Sort       | O(n log n)| O(n log n)| O(n log n)");
    }
}
