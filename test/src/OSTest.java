import dsa.algorithms.OS;
import org.junit.Test;
import practices.waterball.algorithms.WbOS;

import java.util.Arrays;

import static dsa.Utils.*;
import static org.junit.Assert.*;

public class OSTest {
    OS.Banker banker = new WbOS.Banker();

    @Test
    public void testBanker(){
        assertCaseOneBankerSafe();
        assertCaseTwoBankerSafe();
        assertCaseThreeBankerUnsafe();
        assertBankerRequesting1();
        assertBankerRequesting2();
        assertBankerRequesting3();
    }

    private void assertBankerRequesting1() {
        int n = 5, m = 3;
        int[] available = {3, 3, 2};
        int[][] max = {{7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {2, 2, 2}, {4, 3, 3}};
        int[][] allocation = {{0, 5, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
        int[][] need = {{7, 0, 3}, {1, 2, 2}, {6, 0, 0}, {0, 1, 1}, {4, 3, 1}};
        // p1 requests (1 0 2)
        int[][] p1Request = {{0, 0, 0}, {1, 0, 2}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        assertTrue(banker.resourceRequestAlgorithm(n, m, available, max, allocation, need, p1Request).granted);
    }

    private void assertBankerRequesting2() {
        int n = 5, m = 3;
        int[] available = {3, 3, 2};
        int[][] max = {{7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {2, 2, 2}, {4, 3, 3}};
        int[][] allocation = {{0, 5, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
        int[][] need = {{7, 0, 3}, {1, 2, 2}, {6, 0, 0}, {0, 1, 1}, {4, 3, 1}};
        // p4 requests (3 3 0) and p1 requests (1 0 2)
        int[][] p4RequestAfterP1 = {{0, 0, 0}, {1, 0, 2}, {0, 0, 0}, {0, 0, 0}, {3, 3, 0}};

        assertEquals(4, banker.resourceRequestAlgorithm(n, m, available, max, allocation, need, p4RequestAfterP1).mustWaitProcess);

    }

    private void assertBankerRequesting3() {
        int n = 5, m = 3;
        int[] available = {3, 3, 2};
        int[][] max = {{7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {2, 2, 2}, {4, 3, 3}};
        int[][] allocation = {{0, 5, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
        int[][] need = {{7, 0, 3}, {1, 2, 2}, {6, 0, 0}, {0, 1, 1}, {4, 3, 1}};
        int[][] p0RequestAfterAbove = {{0, 2, 0}, {1, 0, 2}, {0, 0, 0}, {0, 0, 0}, {3, 3, 0}};
        //p0 requests (0 2 0), p4 requests (3 3 0) and p1 requests (1 0 2)
        assertFalse(banker.resourceRequestAlgorithm(n, m, available, max, allocation, need, p0RequestAfterAbove).granted);
    }

    private void assertCaseOneBankerSafe(){
        int n = 5, m = 3;
        int[] available = {3, 3, 2};
        int[][] max = {{7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {2, 2, 2}, {4, 3, 3}};
        int[][] allocation = {{0, 1, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
        int[][] need = {{7, 4, 3}, {1, 2, 2}, {6, 0, 0}, {0, 1, 1}, {4, 3, 1}};
        int[] actualSafeSeq = banker.safetyAlgorithm(n, m, available, max, allocation, need);
        System.out.println("Safe sequence: " + Arrays.toString(actualSafeSeq));
        testIfTheSeqActuallySafe(available, allocation, need, actualSafeSeq);
    }

    private void assertCaseTwoBankerSafe() {
        int n = 5, m = 3;
        int[] available = {2, 3, 0};
        int[][] max = {{7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {2, 2, 2}, {4, 3, 3}};
        int[][] allocation = {{0, 1, 0}, {3, 0, 2}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
        int[][] need = {{7, 4, 3}, {0, 2, 0}, {6, 0, 0}, {0, 1, 1}, {4, 3, 1}};
        int[] actualSafeSeq = banker.safetyAlgorithm(n, m, available, max, allocation, need);
        System.out.println("Safe sequence: " + Arrays.toString(actualSafeSeq));
        testIfTheSeqActuallySafe(available, allocation, need, actualSafeSeq);
    }

    private void assertCaseThreeBankerUnsafe() {
        int n = 5, m = 3;
        int[] available = {2, 3, 0};
        int[][] max = {{7, 5, 3}, {3, 2, 2}, {9, 0, 2}, {10, 5, 8}, {4, 3, 3}};
        int[][] allocation = {{0, 1, 0}, {3, 0, 2}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
        int[][] need = {{7, 4, 3}, {0, 2, 0}, {7, 5, 6}, {0, 1, 1}, {4, 3, 1}};
        int[] actualSafeSeq = banker.safetyAlgorithm(n, m, available, max, allocation, need);
        System.out.println("Safe sequence: " + Arrays.toString(actualSafeSeq));
        assertTrue(actualSafeSeq == null);
    }

    private void testIfTheSeqActuallySafe(int[] available, int[][] allocation, int[][] need, int[] actualSafeSeq) {
        for (int process : actualSafeSeq)
        {
            assertTrue(arrayLessOrEqual(need[process], available));
            available = arrayPlus(available, allocation[process]);
        }
    }
}
