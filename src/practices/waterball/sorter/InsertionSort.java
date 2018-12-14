package practices.waterball.sorter;

import dsa.algorithms.sorters.Sorter;

public class InsertionSort implements Sorter {

    @Override
    public void sort(int[] nums) {
        int size = nums.length;

        for (int i = 1; i < size; i ++)
        {
            int target = nums[i];

            int j = i;
            while(j > 0 && target < nums[j-1])
            {
                nums[j] = nums[j-1];
                j --;
            }

            nums[j] = target;
        }
    }
}
