import dsa.algorithms.DynamicProgramming;
import dsa.algorithms.DynamicProgramming.KnapSackAnswer;
import org.junit.Test;
import practices.waterball.algorithms.WbDynamicProgramming;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DynamicProgrammingTest {
    DynamicProgramming dynamicProgramming = new WbDynamicProgramming();  //replace it with yours

    @Test
    public void testLCS(){
        int[] s1 = IntStream.range(1, 50).filter(n -> n % 3 == 0).toArray();
        int[] s2 = IntStream.range(1, 50).filter(n -> n % 2 == 0).toArray();

        // the lcs would be all multiple numbers of 2 and 3, which can be divided by 6
        int[] lcs = IntStream.range(1, 50).filter(n -> n % 6 == 0).toArray();
        assertArrayEquals(lcs, dynamicProgramming.longestCommonSubsequence(s1, s2));
    }

    @Test
    public void testLIS(){
        LinkedList<Integer> nums = new LinkedList<>();
        int[] s1 = new int[200];
        int[] lis = new int[100];
        for (int i = 0; i < 100; i++) {
            nums.add(i);
            lis[i] = i;
        }
        for (int i = 0; i < 100; i++) {
            nums.add(-1);  //make fragments
        }
        for (int i = 0; i < nums.size(); i++) {
            s1[i] = nums.get(i);
        }
        assertArrayEquals(lis, dynamicProgramming.longestIncreasingSequence(s1));
    }

    @Test
    public void testLcString(){
    }

    @Test
    public void test01Knapsack(){
        int[] vs = {10, 6, 12};
        int[] ws = {2, 1, 3};
        HashSet<Integer> takenItems = new HashSet<>();
        takenItems.add(1);
        takenItems.add(3);
        int w = 5;

        KnapSackAnswer answer = dynamicProgramming.R_01knapsack(w, vs, ws);
        assertEquals(22, answer.maximalValue);
        assertEquals(takenItems, answer.takenItems);
    }
}
