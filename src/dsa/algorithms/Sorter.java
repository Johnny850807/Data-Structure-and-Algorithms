package dsa.algorithms;

/**
 * Sort the data structure in the 'ascending' order in each algorithm
 */
public interface Sorter {

    void bubbleSort(int[] nums);

    void insertionSort(int[] nums);

    void selectionSort(int[] nums);

    void shellSort(int[] nums);

    void heapSort(int[] nums);

    void R_mergeSort(int[] nums, int l, int u);

    void R_quickSort(int[] nums, int l, int u);

    void NR_mergeSort(int[] nums);

    void NR_quickSort(int[] nums);

    void radixSort(int[] nums);

    default void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
