package dsa.algorithms;

/**
 * Sort the data structure in the 'ascending' order in each algorithm
 */
public interface Sorter {

    void bubbleSort(int[] nums);

    void insertionSort(int[] nums);

    void heapSort(int[] nums);

    void mergeSort(int[] nums);

    void quickSort(int[] nums);

    void radixSort(int[] nums);

    default void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
