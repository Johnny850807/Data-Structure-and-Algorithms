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

    /**
     * @param startInclusive the start value of the range of the given data inclusively
     * @param endInclusive  the end value of the range of the given data inclusively
     *                      (e.g. if startInclusive=1, endInclusive=10, the data value will be in the range of 1~10)
     */
    void countingSort(int[] nums, int startInclusive, int endInclusive);

    /**
     * @param r digital base
     */
    void radixSort(int[] nums, final int r);

    default void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
