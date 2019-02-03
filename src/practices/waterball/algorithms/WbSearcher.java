package practices.waterball.algorithms;

import dsa.algorithms.Searcher;

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class WbSearcher implements Searcher {
    private WbSorter sorter = new WbSorter();

    @Override
    public int linearSearch(int[] array, int data) {
        int i = array.length-1;
        try {
            while(array[i] != data)
                i -= 1;
        }catch (ArrayIndexOutOfBoundsException ignored){}
        return i;
    }

    @Override
    public int NR_binarySearch(int[] array, int data) {
        int l = 0, u = array.length-1;
        int m;
        while(l <= u)
        {
            m = (l+u)/2;
            if (array[m] == data)
                return m;
            if (data < array[m])
                u = m-1;
            else
                l = m+1;
        }
        return -1;
    }

    @Override
    public int R_binarySearch(int[] array, int data, int l, int u) {
        int m = (l+u)/2;
        if (l > u)
            return -1;
        if (array[m] == data)
            return m;
        return data < array[m]? R_binarySearch(array, data, l, m-1) : R_binarySearch(array, data, m+1, u);
    }

    @Override
    public MinMax findMinMax(int[] nums) {
        return findMinMax(nums, 0, nums.length-1);
    }

    @Override
    public int findMode(int[] nums) {
        //TODO
        return 0;
    }

    private MinMax findMinMax(int[] nums, int l, int r){
        int x = min(nums[l], nums[l+1]);
        int y = max(nums[l], nums[l+1]);
        if (l+2 < r)
        {
            MinMax minMax = findMinMax(nums, l+2, r);
            return new MinMax(min(x, minMax.min), max(y, minMax.max));  //Comparisons: T(n) = T(n-2) + 3 = 3n/2 < naive way: T(n) = 2(n-1)
        }
        else
            return new MinMax(x, y);
    }

    @Override
    public int selectionMin(int[] nums, int k) {
        //(k-1): start from 0, e.g. if desired the first small number means 0th small number
        return selectionMin(nums, 0, nums.length-1, k-1);
    }

    private int selectionMin(int[] nums, int l, int r, int k){
        if (l < r){
            int pivotVal = medianOfMedians(nums, l, r);
            int p = partition(nums, pivotVal, l, r);  //use medium of mediums to find Pivot val for partitioning :O(n)
            if (k+l < p)  //note: k must plus l because k's index should be offset from l
                return selectionMin(nums, l, p-1, k);
            if (k+l == p)
                return nums[p];
            else
                return selectionMin(nums, p+1, r, (k+l)-p-1);
        }
        else
            return nums[l];
    }

    /**
     * @return index of the pivot
     */
    private int partition(int[] nums, int pivot, int l, int r){
        for (int j = l; j <= r; j++) {  //look for the pivot position
            if (nums[j] == pivot)
            {
                swap(nums, j, r);  //swap the pivot to the rightest position
                break;
            }
        }

        int i = l;
        for (int j = l; j < r; j++) {
            if (nums[j] <= pivot)
                swap(nums, i++, j);
        }

        swap(nums, i, r);
        return i;
    }

    private int medianOfMedians(int[] nums, int l, int r){
        return medianOfMedians(Arrays.copyOfRange(nums, l, r+1));
    }

    private int medianOfMedians(int[] nums){
        int groupCount = ceil(nums.length/5.0);
        int[][] groups = new int[groupCount][5];

        // Insertion Sort used by this algorithm costs Only O(1),
        // because the size of sorted array is always of length 5 : O(5*5)=O(25)=O(1)
        if (groupCount == 1){
            sorter.insertionSort(nums);
            return nums[nums.length/2];  //final median
        }

        //(1) Put nums into each groups : O(n)
        for (int i = 0; i < groupCount; i++) {
            for (int j = 0; j < 5; j++) {
                int idx = i*5+j;
                if (idx < nums.length)
                    groups[i][j] = nums[i*5+j];
            }
        }

        //(2) Sort each group by insertion sort : O(n) + O(n) + ... + O(n) = O(n)
        for (int[] group : groups)
            sorter.insertionSort(group);

        //(3) Recursively get the median of medians until there remains only one group : O(n)
        int[] mediums = new int[groupCount];
        for (int i = 0; i < groupCount; i++) {
            mediums[i] = groups[i][2];
        }

        return medianOfMedians(mediums);
    }


    private int ceil(double num){
        return (int) Math.ceil(num);
    }
    private double log(int base, int number){
        return Math.log(number) / Math.log(base);
    }

}
