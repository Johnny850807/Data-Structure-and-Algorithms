package practices.waterball.sorter;

import dsa.algorithms.sorters.Sorter;
import dsa.datastructures.DataStructure;

public class InsertionSort implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(DataStructure<T> ds) {
        int size = ds.size();

        for (int i = 1; i < size; i ++)
        {
            T target = ds.get(i);

            int j = i;
            while(j > 0 && target.compareTo(ds.get(j-1)) < 0)
            {
                ds.set(j, ds.get(j-1));
                j --;
            }

            ds.set(j, target);
        }
    }
}
