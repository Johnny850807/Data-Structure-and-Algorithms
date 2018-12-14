import dsa.algorithms.Recursives;
import org.junit.Test;
import practices.waterball.WbRecursives;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("ALL")
public class RecursivesTest {
    Recursives recursives = new WbRecursives();  // replace with your own implementation

    @Test
    public void outputTest(){
        assertEquals(recursives.R_Factorization(10), recursives.NR_Factorization(10));
        assertEquals(3628800, recursives.NR_Factorization(10));


        assertEquals(recursives.R_binomialCoefficient(7, 2), recursives.NR_binomialCoefficient(7, 2));
        assertEquals(21, recursives.NR_binomialCoefficient(7, 2));


        assertEquals(recursives.R_Fibonacci(17), recursives.NR_Fibonacci(17));
        assertEquals(1597, recursives.R_Fibonacci(17));

        assertEquals(recursives.R_gcd(150, 175), recursives.NR_gcd(150, 175));
        assertEquals(25, recursives.NR_gcd(150, 175));
    }

    @Test
    public void noOutputTest(){
        go("R_towerOfHanoi", ()-> recursives.R_towerOfHanoi(3, 'A', 'B', 'C'));
        go("R_permutation", ()-> recursives.R_permutation(new int[]{0, 1,2}, 0, 2));
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
