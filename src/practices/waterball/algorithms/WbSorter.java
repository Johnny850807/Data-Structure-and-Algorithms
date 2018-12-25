package practices.waterball.algorithms;

import dsa.algorithms.Sorter;

public class WbSorter implements Sorter {

    @Override
    public void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++)
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            if (!swapped)
                break;
        }
    }

    @Override
    public void insertionSort(int[] nums) {
        int size = nums.length;

        for (int i = 1; i < size; i++) {
            int target = nums[i];

            int j = i;
            while (j > 0 && target < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }

            nums[j] = target;
        }
    }

    @Override
    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++)
                if (nums[j] < nums[minIndex])
                    minIndex = j;

            if (i != minIndex)
                swap(nums, i, minIndex);
        }
    }

    @Override
    public void shellSort(int[] nums) {

    }

    @Override
    public void heapSort(int[] nums) {

    }

    @Override
    public void R_mergeSort(int[] nums, int l, int u) {

    }

    @Override
    public void R_quickSort(int[] nums, int l, int u) {
        int i, j;
        int p;
        if (l < u) {
            i = l + 1;
            j = u;
            p = nums[l];
            do {
                while (i <= j && nums[i] <= p)
                    i++;
                while (i <= j && nums[j] > p)
                    j--;
                if (i < j)
                    swap(nums, i, j);
            } while (i < j);
            if (l < j)
                swap(nums, l, j);
            R_quickSort(nums, l, j - 1);
            R_quickSort(nums, j + 1, u);
        }
    }


    @Override
    public void NR_mergeSort(int[] nums) {

    }

    @Override
    public void NR_quickSort(int[] nums) {

    }

    @Override
    public void radixSort(int[] nums) {

    }
}
