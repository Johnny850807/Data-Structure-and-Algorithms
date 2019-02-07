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

    /**
     * @return the i-th small number in nums
     */
    int selectionMin(int[] nums, int k);

    /**
     * @return the majority among the numbers, return -1 if the majority does not exit.
     */
    MinMax findMinMax(int[] nums);

    int findMajority(int[] nums);

    default void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static class MinMax{
        public int min;
        public int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
