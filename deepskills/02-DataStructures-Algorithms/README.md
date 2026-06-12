# Module 2: Data Structures & Algorithms

**Status:** ✅ Successful

---

## Structure

```
02-DataStructures-Algorithms/
├── DataStructures/
│   ├── LinkedList/   → Node.java, SinglyLinkedList.java, LinkedListDemo.java
│   ├── Stack/        → MyStack.java, StackDemo.java
│   ├── Queue/        → MyQueue.java, QueueDemo.java
│   ├── BinaryTree/   → TreeNode.java, BinaryTree.java, BinaryTreeDemo.java
│   └── screenshots/
└── Algorithms/
    ├── Searching/    → LinearSearch.java, BinarySearch.java, SearchingDemo.java
    ├── Sorting/      → BubbleSort.java, InsertionSort.java, QuickSort.java,
    │                   MergeSort.java, HeapSort.java, SortingDemo.java
    └── screenshots/
```

---

## Data Structures

| DS | Operations | Code |
|----|-----------|------|
| **LinkedList** | Insert, Delete, Search, Traverse, Reverse | `SinglyLinkedList` with `Node` inner class |
| **Stack** | Push, Pop, Peek, isEmpty, isFull | Array-based LIFO (`MyStack`) |
| **Queue** | Enqueue, Dequeue, Display | Array-based FIFO (`MyQueue`) |
| **BinaryTree** | Inorder, Preorder, Postorder, Height | `TreeNode` + recursive traversal |

---

## Algorithms

| Algorithm | Type | Time (Avg) | Code |
|-----------|------|-----------|------|
| **Linear Search** | Searching | O(n) | Scans array sequentially |
| **Binary Search** | Searching | O(log n) | Divide & conquer (iterative + recursive) |
| **Bubble Sort** | Sorting | O(n^2) | Adjacent swaps, optimized with flag |
| **Insertion Sort** | Sorting | O(n^2) | Builds sorted array one by one |
| **Quick Sort** | Sorting | O(n log n) | Partition around pivot |
| **Merge Sort** | Sorting | O(n log n) | Divide, sort, merge |
| **Heap Sort** | Sorting | O(n log n) | Build heap, extract max |

---

## Run

```bash
# Data Structures
cd "02-DataStructures-Algorithms"
javac -sourcepath . -cp . DataStructures/LinkedList/LinkedListDemo.java && java -cp . DataStructures.LinkedList.LinkedListDemo
javac -sourcepath . -cp . DataStructures/Stack/StackDemo.java && java -cp . DataStructures.Stack.StackDemo
javac -sourcepath . -cp . DataStructures/Queue/QueueDemo.java && java -cp . DataStructures.Queue.QueueDemo
javac -sourcepath . -cp . DataStructures/BinaryTree/BinaryTreeDemo.java && java -cp . DataStructures.BinaryTree.BinaryTreeDemo

# Algorithms
javac -sourcepath . -cp . Algorithms/Searching/SearchingDemo.java && java -cp . Algorithms.Searching.SearchingDemo
javac -sourcepath . -cp . Algorithms/Sorting/SortingDemo.java && java -cp . Algorithms.Sorting.SortingDemo
```
