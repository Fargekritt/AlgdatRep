package org.algdat.quicksort;
// Java implementation of QuickSort

class QuickSort {

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
    the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
    to left of pivot and all greater elements to right
    of pivot */
    static int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int leftPointer = low;
        int rightPointer = high +1;

        while (leftPointer < rightPointer) {

            // Walk from the left until we find a number greater than the pivot, or hit the right pointer.
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            // Walk from the right until we find a number less than the pivot, or hit the left pointer.
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(arr, leftPointer, rightPointer);
        }


        if(arr[leftPointer] > arr[high]) {
            swap(arr, leftPointer, high);
        }
        else {
            leftPointer = high;
        }

        return leftPointer;
    }

    /* The main function that implements QuickSort
            arr[] --> Array to be sorted,
            lowIndex --> Starting index,
            highIndex --> Ending index
    */
    static void quickSort(int[] arr, int lowIndex, int highIndex)
    {
        if (lowIndex < highIndex) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int partition = partition(arr, lowIndex, highIndex);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, lowIndex, partition - 1);
            quickSort(arr, partition + 1, highIndex);
        }
    }

    // Function to print an array
    static void printArray(int[] arr, int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = {9, 100, 2, 5};
        //int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
        //int[] arr = { 38, 27, 43, 3, 9, 82, 10, 100, 123, 345346, 1232, 0, -1, 222 };
        int n = arr.length;

        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}

// This code is contributed by Ayush Choudhary
