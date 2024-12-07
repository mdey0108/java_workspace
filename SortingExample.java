public class SortingExample {
    public static void main(String[] args) {
        // Example array
        int[] originalNumbers = { 5, 2, 8, 4, 1, 9, 7 };

        System.out.println("Original Array:");
        printArray(originalNumbers);

        // Bubble Sort
        int[] bubbleSortedNumbers = originalNumbers.clone();
        long bubbleStart = System.nanoTime();
        bubbleSort(bubbleSortedNumbers);
        long bubbleEnd = System.nanoTime();
        System.out.println("Array Sorted Using Bubble Sort:");
        printArray(bubbleSortedNumbers);
        System.out.println("Time Taken by Bubble Sort: " + (bubbleEnd - bubbleStart) + " nanoseconds\n");

        // Merge Sort
        int[] mergeSortedNumbers = originalNumbers.clone();
        long mergeStart = System.nanoTime();
        mergeSort(mergeSortedNumbers, 0, mergeSortedNumbers.length - 1);
        long mergeEnd = System.nanoTime();
        System.out.println("Array Sorted Using Merge Sort:");
        printArray(mergeSortedNumbers);
        System.out.println("Time Taken by Merge Sort: " + (mergeEnd - mergeStart) + " nanoseconds\n");

        // Quick Sort
        int[] quickSortedNumbers = originalNumbers.clone();
        long quickStart = System.nanoTime();
        quickSort(quickSortedNumbers, 0, quickSortedNumbers.length - 1);
        long quickEnd = System.nanoTime();
        System.out.println("Array Sorted Using Quick Sort:");
        printArray(quickSortedNumbers);
        System.out.println("Time Taken by Quick Sort: " + (quickEnd - quickStart) + " nanoseconds\n");

        // Insertion Sort
        int[] insertionSortedNumbers = originalNumbers.clone();
        long insertionStart = System.nanoTime();
        insertionSort(insertionSortedNumbers);
        long insertionEnd = System.nanoTime();
        System.out.println("Array Sorted Using Insertion Sort:");
        printArray(insertionSortedNumbers);
        System.out.println("Time Taken by Insertion Sort: " + (insertionEnd - insertionStart) + " nanoseconds\n");
    }

    // Bubble Sort algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    // Merge Sort algorithm
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2)
            arr[k++] = (leftArray[i] <= rightArray[j]) ? leftArray[i++] : rightArray[j++];
        while (i < n1)
            arr[k++] = leftArray[i++];
        while (j < n2)
            arr[k++] = rightArray[j++];
    }

    // Quick Sort algorithm
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Insertion Sort algorithm
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
