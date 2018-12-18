import com.sun.org.apache.bcel.internal.generic.ALOAD;
import dsa.algorithms.OS;
import org.junit.Assert;
import org.junit.Test;
import practices.waterball.algorithms.WbOS;

import java.util.Arrays;

import static dsa.Utils.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class OSTest {
    OS.Banker banker = new WbOS.Banker();

    @Test
    public void testBanker(){
        assertCaseOneBankerSafe();
    }

    private void assertCaseOneBankerSafe(){
        int n = 5, m = 3;
        int[] available = {3, 3, 2};
        int[][] max = {{7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {2, 2, 2}, {4, 3, 3}};
        int[][] allocation = {{0, 1, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
        int[][] need = {{7, 4, 3}, {1, 2, 2}, {6, 0, 0}, {0, 1, 1}, {4, 3, 1}};
        int[] actualSafeSeq = banker.safetyAlgorithm(n, m, available, max, allocation, need);
        System.out.println("Safe sequence: " + Arrays.toString(actualSafeSeq));
        testIfTheSeqActuallySafe(available, allocation, need, new int[]{1, 3, 4, 2, 0});
    }

    private void testIfTheSeqActuallySafe(int[] available, int[][] allocation, int[][] need, int[] actualSafeSeq) {
        for (int process : actualSafeSeq)
        {
            assertTrue(arrayLessOrEqual(need[process], available));
            available = arrayPlus(available, allocation[process]);
        }
    }

}
