package practices.waterball.algorithms;

import dsa.algorithms.Searcher;

public class WbSearcher implements Searcher {
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
    public int fibonacciSearch(int[] array, int data) {
        return 0;
    }

    @Override
    public int interpolationSearch(int[] array, int data) {
        return 0;
    }
}
