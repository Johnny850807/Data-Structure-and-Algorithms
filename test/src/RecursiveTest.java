import dsa.Utils;
import dsa.algorithms.BasicRecursive;
import org.junit.Test;
import practices.waterball.algorithms.WbRecursive;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ALL")
public class RecursiveTest {
    BasicRecursive recursive = new WbRecursive();  // replace with your own implementation

    @Test
    public void outputTest(){
        assertEquals(recursive.R_Factorization(10), recursive.NR_Factorization(10));
        assertEquals(3628800, recursive.NR_Factorization(10));


        assertEquals(recursive.R_binomialCoefficient(7, 2), recursive.NR_binomialCoefficient(7, 2));
        assertEquals(21, recursive.NR_binomialCoefficient(7, 2));


        assertEquals(recursive.R_Fibonacci(17), recursive.NR_Fibonacci(17));
        assertEquals(1597, recursive.R_Fibonacci(17));

        assertEquals(recursive.R_gcd(150, 175), recursive.NR_gcd(150, 175));
        assertEquals(25, recursive.NR_gcd(150, 175));
    }

    @Test
    public void noOutputTest(){
        go("R_towerOfHanoi", ()-> recursive.R_towerOfHanoi(3, 'A', 'B', 'C'));
        go("R_generatePermutation", ()-> recursive.R_generatePermutation(new int[]{0, 1,2}, 0, 2));
    }

    @Test
    public void testPowerSet(){
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        int[][] expectedPowerSetArray = {{}, {1}, {2}, {3}, {1, 2}, {2, 3}, {1, 3}, {1, 2, 3}};
        HashSet<HashSet<Integer>> expectedPowerSet = new HashSet<>();
        for (int i = 0; i < expectedPowerSetArray.length; i++) {
            HashSet<Integer> subset = new HashSet<>();
            for (int j = 0; j < expectedPowerSetArray[i].length; j++) {
                subset.add(expectedPowerSetArray[i][j]);
            }
            expectedPowerSet.add(subset);
        }

        HashSet<HashSet<Integer>> actualPowerSet = recursive.powerSet(set);
        System.out.println("Power set of {1,2,3} = \n" + Utils.setToString(actualPowerSet));
        for (HashSet<Integer> subset : actualPowerSet) {
            assertTrue(expectedPowerSet.contains(subset));
        }

    }
    int noOutputTestCount = 1;
    private void go(String name, Runnable testcase){
        System.out.println("(" + noOutputTestCount + ") ================");
        System.out.println(name + ":");
        testcase.run();
        System.out.println(name + " completed.");
        System.out.println("=====================");
    }
}
