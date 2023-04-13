package org.algdat.mergeSort;

//MergeSort algorithm
class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[startIndex..middleIndex]
    // Second subarray is arr[middleIndex+1..lastIndex]
    void merge(int[] arr, int startIndex, int middleIndex, int lastIndex) {
        // Find sizes of two subarrays to be merged
        int leftArraySize = middleIndex - startIndex + 1;
        int rightArraySize = lastIndex - middleIndex;

        // Create temp arrays
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        //Copy data to temp arrays
        for (int i = 0; i < leftArraySize; ++i)
            leftArray[i] = arr[startIndex + i];

        for (int j = 0; j < rightArraySize; ++j)
            rightArray[j] = arr[middleIndex + 1 + j];

        //Merge temp arrays

        // Initial indexes of first and second subarrays
        int leftSubArrayIndex = 0, rightSubArrayIndex = 0;

        // Initial index of merged subarray array
        int arrayIndex = startIndex;
        while (leftSubArrayIndex < leftArraySize && rightSubArrayIndex < rightArraySize) {

            if (leftArray[leftSubArrayIndex] <= rightArray[rightSubArrayIndex]) {
                arr[arrayIndex] = leftArray[leftSubArrayIndex];
                leftSubArrayIndex++;
            } else {
                arr[arrayIndex] = rightArray[rightSubArrayIndex];
                rightSubArrayIndex++;
            }
            arrayIndex++;
        }

        /* Copy remaining elements of L[] if any */
        while (leftSubArrayIndex < leftArraySize) {
            arr[arrayIndex] = leftArray[leftSubArrayIndex];
            leftSubArrayIndex++;
            arrayIndex++;
        }

        /* Copy remaining elements of R[] if any */
        while (rightSubArrayIndex < rightArraySize) {
            arr[arrayIndex] = rightArray[rightSubArrayIndex];
            rightSubArrayIndex++;
            arrayIndex++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int[] inputArray, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            // Find the middle point
            int middleIndex = firstIndex + (lastIndex - firstIndex) / 2;

            // Sort first and second halves
            sort(inputArray, firstIndex, middleIndex);
            sort(inputArray, middleIndex + 1, lastIndex);

            // Merge the sorted halves
            merge(inputArray, firstIndex, middleIndex, lastIndex);
        }
    }

    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {9, 100, 2, 5};
        //int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
        //int[] arr = { 38, 27, 43, 3, 9, 82, 10, 100, 123, 345346, 1232, 0, -1, 222 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
/* This code is contributed by Rajat Mishra */
