package dsa.algorithms;

/**
 * The return number is the index of the targeted data
 */
public interface Searcher {
    int linearSearch(int[] array, int data);
    int NR_binarySearch(int[] array, int data);

    /**
     * @param l lower bound
     * @param u upper bound
     */
    int R_binarySearch(int[] array, int data, int l, int u);
    int fibonacciSearch(int[] array, int data);
    int interpolationSearch(int[] array, int data);
}
