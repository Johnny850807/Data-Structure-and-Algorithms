import dsa.algorithms.BasicRecursive;
import org.junit.Test;
import practices.waterball.WbBasicRecursive;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("ALL")
public class BasicRecursiveTest {
    BasicRecursive basicRecursive = new WbBasicRecursive();  // replace with your own implementation

    @Test
    public void outputTest(){
        assertEquals(basicRecursive.R_Factorization(10), basicRecursive.NR_Factorization(10));
        assertEquals(3628800, basicRecursive.NR_Factorization(10));


        assertEquals(basicRecursive.R_binomialCoefficient(7, 2), basicRecursive.NR_binomialCoefficient(7, 2));
        assertEquals(21, basicRecursive.NR_binomialCoefficient(7, 2));


        assertEquals(basicRecursive.R_Fibonacci(17), basicRecursive.NR_Fibonacci(17));
        assertEquals(1597, basicRecursive.R_Fibonacci(17));

        assertEquals(basicRecursive.R_gcd(150, 175), basicRecursive.NR_gcd(150, 175));
        assertEquals(25, basicRecursive.NR_gcd(150, 175));
    }

    @Test
    public void noOutputTest(){
        go("R_towerOfHanoi", ()-> basicRecursive.R_towerOfHanoi(3, 'A', 'B', 'C'));
        go("R_generatePermutation", ()-> basicRecursive.R_generatePermutation(new int[]{0, 1,2}, 0, 2));
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
