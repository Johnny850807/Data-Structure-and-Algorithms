package practices.waterball.algorithms;

import dsa.algorithms.OS;
import static dsa.Utils.*;
import java.util.Arrays;

public class WbOS implements OS {

    public static class Banker implements OS.Banker{

        @Override
        public int[] safetyAlgorithm(int n, int m, int[] available, int[][] max, int[][] allocation, int[][] need) {
            int finishCount = 0;
            int[] safeSequence = new int[n];
            boolean[] finish = new boolean[n];
            boolean hasFoundNextSafeAllocation;

            do {  // this loop has [n + (n-1) + ... + 1] = n(n+1)/2 = O(n^2)
                hasFoundNextSafeAllocation = false;
                // found through process
                for (int i = 0; i < n; i ++)
                {
                    // find the next unfinished process which its need is less then available amount
                    if (!finish[i] && arrayLessOrEqual(need[i], available))
                    {
                        // this process can finish its work and return those resources
                        available = arrayPlus(available, allocation[i]);  //O(m)
                        finish[i] = true;
                        hasFoundNextSafeAllocation = true;
                        safeSequence[finishCount++] = i;
                    }
                }
            } while (hasFoundNextSafeAllocation);

            for (int i = 0; i < finish.length; i ++)
                if (!finish[i])
                    return null;
            return safeSequence; // this algorithm has O(m*n^2)
        }


        @Override
        public RequestGrantState resourceRequestAlgorithm(int n, int m, int[] available, int[][] max, int[][] allocation, int[][] need, int[][] request) {
            for(int i = 0; i < n; i ++)
            {
                if (arrayLessOrEqual(request[i], need[i]))
                {
                    if (arrayLessOrEqual(request[i] , available))
                    {
                        // have the system pretend to have allocated the requested resources to process
                        available = arraySub(available, request[i]);
                        allocation[i] = arrayPlus(allocation[i], request[i]);
                        need[i] = arraySub(need[i], request[i]);
                    }
                    else
                    {
                        System.out.println("The process " + i + " must wait, since the resources are not available.");
                        return RequestGrantState.mustWait(i);
                    }
                }
                else
                    return RequestGrantState.nonAvailable();
            }

            return safetyAlgorithm(n, m, available, max, allocation, need) == null ?
                    RequestGrantState.unsafeNotGranted() : RequestGrantState.safeGranted();
        }

    }
}
