import dsa.algorithms.DynamicProgramming;
import dsa.algorithms.DynamicProgramming.KnapSackAnswer;
import dsa.algorithms.DynamicProgramming.MatrixChainAnswer;
import dsa.algorithms.DynamicProgramming.MinimumEditDistance.Edition.Type;
import dsa.algorithms.DynamicProgramming.TwoSequenceAlignmentAnswer;
import org.junit.Test;
import practices.waterball.algorithms.WbDynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

import static dsa.algorithms.DynamicProgramming.MinimumEditDistance.Edition.Type.INSERT;
import static dsa.algorithms.DynamicProgramming.MinimumEditDistance.Edition.Type.REMOVE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
    public void testLIS() {
        int[] s1 = new int[]{66, 92, 123, 31, 83, 53, 48, 17, 9, 57, 75};
        int[] expectedLIS = new int[]{31, 53, 57, 75};
        int[] actualLIS = dynamicProgramming.longestIncreasingSequence(s1);
        System.out.println(Arrays.toString(actualLIS));
        assertArrayEquals(expectedLIS, actualLIS);
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

    @Test
    public void testMatrixChainMultiplication(){
        String[] matrices = {"A", "B", "C", "D", "E"};
        int[] p = {2, 4, 3, 2, 5, 1};
        MatrixChainAnswer answer = dynamicProgramming.matrixChainMultiplication(matrices, p);
        assertEquals(36, answer.numberOfMultiplications);
        assertEquals("(A(B(C(DE))))", answer.matrixChain);
        System.out.printf("Matrix Chain: %s, min multiplication: %d\n", answer.matrixChain, answer.numberOfMultiplications);
    }

    @Test
    public void testMinimumEditDistance(){
        int expectedDistance = 4;
        Type[] expectedEdtionTypes = new Type[]{REMOVE, REMOVE, INSERT, INSERT};
        DynamicProgramming.MinimumEditDistance med = dynamicProgramming.minimumEditDistance(
                new StringBuilder("acbabca"), new StringBuilder("babcbac"));
        System.out.println("Minimum Edit Distance: \n" + med);
        for (int i = 0; i < expectedDistance; i++) {
            assertEquals(expectedEdtionTypes[i], med.editions.get(i).type);
        }
    }

    @Test
    public void testTwoSequenceAlignment(){
        StringBuilder A = new StringBuilder("APPLE");
        StringBuilder B = new StringBuilder("APPE");
        String expectedAlignment = "APP-E";
        int expectedPoint = 3;
        TwoSequenceAlignmentAnswer alignmentAnswer = dynamicProgramming.twoSequenceAlignment(A, B);
        assertEquals(expectedAlignment, alignmentAnswer.alignment);
        assertEquals(expectedPoint, alignmentAnswer.point);
        //..
    }
}
