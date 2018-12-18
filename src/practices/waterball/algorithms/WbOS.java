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

            do {
                hasFoundNextSafeAllocation = false;
                // found through process
                for (int i = 0; i < n; i ++)
                {
                    // find the next unfinished process which its need is less then available amount
                    if (!finish[i] && arrayLessOrEqual(need[i], available))
                    {
                        // this process can finish its work and return those resources
                        available = arrayPlus(available, allocation[i]);
                        finish[i] = true;
                        hasFoundNextSafeAllocation = true;
                        safeSequence[finishCount++] = i;
                    }
                }
            } while (hasFoundNextSafeAllocation);

            for (int i = 0; i < finish.length; i ++)
                if (!finish[i])
                    return null;
            return safeSequence;
        }


        @Override
        public boolean resourceRequestAlgorithm(int n, int m, int[] available, int[][] max, int[][] allocation, int[][] need, int[][] request) {
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
                        return false;
                    }
                }
                else
                    throw new RuntimeException("The process has exceeded its maximum need claim.");
            }

            return true;
        }

    }
}
