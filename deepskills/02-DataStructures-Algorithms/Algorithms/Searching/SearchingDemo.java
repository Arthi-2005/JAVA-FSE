package Algorithms.Searching;

import java.util.Arrays;

public class SearchingDemo {
    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        int target = 22;
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Linear Search for " + target + ": index " + LinearSearch.search(arr.clone(), target));

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        System.out.println("Sorted: " + Arrays.toString(sortedArr));
        System.out.println("Binary Search (Iterative) for " + target + ": index " + BinarySearch.searchIterative(sortedArr, target));
        System.out.println("Binary Search (Recursive) for " + target + ": index " + BinarySearch.searchRecursive(sortedArr, 0, sortedArr.length - 1, target));
    }
}
