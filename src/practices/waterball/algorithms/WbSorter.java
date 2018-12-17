package practices.waterball.algorithms;

import dsa.algorithms.Sorter;

public class WbSorter implements Sorter {

    @Override
    public void bubbleSort(int[] nums) {
        int size = nums.length;

        for (int i = 0; i < size - 1; i ++)
            for (int j = i + 1; j < size; j ++)
                if (nums[i] > nums[j])
                    swap(nums, i, j);
    }

    @Override
    public void insertionSort(int[] nums) {
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

    @Override
    public void heapSort(int[] nums) {

    }

    @Override
    public void mergeSort(int[] nums) {

    }

    @Override
    public void quickSort(int[] nums) {

    }

    @Override
    public void radixSort(int[] nums) {

    }
}
