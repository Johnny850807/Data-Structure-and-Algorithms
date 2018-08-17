package dsa.algorithms.sorters;

import dsa.datastructures.DataStructure;

public interface Sorter {

    default <T extends Comparable<T>> void sort(DataStructure<T> dataStructure, boolean ascending){
        this.sort(dataStructure);

        if (!ascending)
            dataStructure.reverse();
    }

    /**
     * Sort the data structure in the 'ascending' order.
     * @param ds the sorted data structure
     * @param <T> the element type which should be comparable
     */
    <T extends Comparable<T>> void sort(DataStructure<T> ds);


}
