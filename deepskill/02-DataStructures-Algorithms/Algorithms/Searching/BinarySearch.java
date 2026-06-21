package Algorithms.Searching;

public class BinarySearch {
    public static int searchIterative(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int searchRecursive(int[] arr, int left, int right, int target) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) return searchRecursive(arr, mid + 1, right, target);
            return searchRecursive(arr, left, mid - 1, target);
        }
        return -1;
    }
}
