package practices.waterball.algorithms;

import dsa.algorithms.OS;

import java.util.Arrays;

public class WbOS implements OS {

    public class Banker implements OS.Banker{

        @Override
        public boolean safetyAlgorithm(int n, int m, int[] available, int[][] max, int[][] allocation, int[][] need) {
            boolean[] finish = new boolean[n];

            // for each process
            for (int i = 0; i < n; i ++)
            {
                // find the next unfinished process which its need is less then available amount
                if (!finish[i] && arrayLessOrEqual(need[i], available))
                {
                    // this process can finish its work and return those resources
                    available = arrayPlus(available, allocation[i]);
                    finish[i] = true;
                }
            }

            for (int i = 0; i < finish.length; i ++)
                if (!finish[i])
                    return false;
            return true;
        }

        private boolean arrayLessOrEqual(int[] arr1, int[] arr2){
            for (int i = 0; i < arr1.length; i ++)
                if (arr1[i] > arr2[i])
                    return false;
            return true;
        }

        private int[] arrayPlus(int[] arr1, int[] arr2){
            int[] s = new int[arr1.length];
            for (int i = 0; i < arr1.length; i ++)
                s[i] = arr1[i] + arr2[i];
            return s;
        }

        @Override
        public boolean resourceRequestAlgorithm(int n, int m, int[] available, int[][] max, int[][] allocation, int[][] need, int[][] request) {
            return false;
        }
    }
}
