package practices.waterball.algorithms;

import dsa.Utils;
import dsa.algorithms.Sorter;

import java.util.LinkedList;

import static java.lang.Math.*;

@SuppressWarnings("ForLoopReplaceableByForEach")
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
        int n = nums.length;
        int[] temp = Utils.padddingZero(nums, 0, 1); //padding zero so the index starts from 1 to n
        for (int i = n/2; i >= 1; i --) //max-heapify (If you want to sort in ascending, you have to max-heapify it instead of min-heapify)
            adjustMaxHeap(temp, i, n);

        for (int i = n-1; i >= 1; i --)  //swap & delete last node until (n-1) times
        {
            swap(temp, 1, i+1);  //swap with the last node
            adjustMaxHeap(temp, 1, i);  //delete the last node then adjust
        }


        System.arraycopy(temp, 1, nums, 0, n); //copy the max-heap sorted result back
    }

    private void adjustMaxHeap(int[] nums, int i, int n){
        int j = i * 2;
        boolean done = false;
        while (j <= n && !done)
        {
            if (j < n && nums[j] < nums[j+1])
                j ++;
            if (nums[i] < nums[j])
            {
                swap(nums, i, j);
                i = j;
                j = i * 2;
            }
            else
                done = true;
        }
    }

    @SuppressWarnings("ManualArrayCopy")
    private void R_merge(int[] nums, final int lStart, final int lEnd, final int rStart, final int rEnd){
        int length = rEnd - lStart + 1;
        int[] temp = new int[length];  //extra space costs : space complexity O(n)
        int p = 0;
        int i = lStart;
        int j = rStart;

        while(i <= lEnd && j <= rEnd)
        {
            if (nums[i] < nums[j])
                temp[p++] = nums[i++];
            else
                temp[p++] = nums[j++];
        }

        while (i <= lEnd)
            temp[p++] = nums[i++];
        while (j <= rEnd)
            temp[p++] = nums[j++];

        for (int k = 0; k < length; k++) {
            nums[k+lStart] = temp[k];
        }
    }

    @Override
    public void R_mergeSort(int[] nums, int l, int r) {
        if (l < r)
        {
            int m = (l+r)/2;
            R_mergeSort(nums, l, m);
            R_mergeSort(nums, m+1, r);
            R_merge(nums, l, m, m+1, r);
        }
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
    @SuppressWarnings("unchecked")
    public void radixSort(int[] nums, final int r) {
        int d = 0;
        LinkedList<Integer>[] buckets = new LinkedList[r];


        for (int i = 0; i < nums.length; i++)
            d = max(ceil(log(r, nums[i])), d);

        for (int i = 0; i < d; i ++)
        {
            for (int k = 0; k < buckets.length; k++)   //refresh buckets
                buckets[k] = new LinkedList<>();

            for (int k = 0; k < nums.length; k ++)
            {
                int digit = (int) ((nums[k] / pow(r, i)) % r);
                buckets[digit].addLast(nums[k]);
            }
            int p = 0;
            for (LinkedList<Integer> bucket : buckets)
                while (!bucket.isEmpty())
                    nums[p++] = bucket.pollFirst();
        }
    }

    private int ceil(double num){
        return (int) Math.ceil(num);
    }
    private double log(int base, int number){
        return Math.log(number) / Math.log(base);
    }
}
