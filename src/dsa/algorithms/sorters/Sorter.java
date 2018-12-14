package dsa.algorithms.sorters;

import dsa.Utils;

public interface Sorter {

    default void sort(int[] nums, boolean ascending){
        this.sort(nums);

        if (!ascending)
            Utils.reverseArray(nums);
    }

    /**
     * Sort the data structure in the 'ascending' order.
     * @param nums numbers
     * @param <T> the element type which should be comparable
     */
    <T extends Comparable<T>> void sort(int[] nums);


}
