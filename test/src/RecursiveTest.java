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
    public void noOutputTest(){
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
    public void outputTest(){
        go("R_towerOfHanoi", ()-> recursive.R_towerOfHanoi(3, 'A', 'B', 'C'));
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
