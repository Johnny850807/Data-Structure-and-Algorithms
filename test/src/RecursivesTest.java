import dsa.algorithms.Recursives;
import org.junit.Assert;
import org.junit.Test;
import practices.waterball.MyRecursives;

import static org.junit.Assert.assertEquals;

public class RecursivesTest {
    Recursives recursives = new MyRecursives();  // replace with your own implementation

    @Test
    public void test(){
        assertEquals(recursives.R_Factorization(10), recursives.NR_Factorization(10));
        assertEquals(3628800, recursives.NR_Factorization(10));


        assertEquals(recursives.R_binomialCoefficient(7, 2), recursives.NR_binomialCoefficient(7, 2));
        assertEquals(21, recursives.NR_binomialCoefficient(7, 2));


        assertEquals(recursives.R_Fibonacci(17), recursives.NR_Fibonacci(17));
        assertEquals(1597, recursives.R_Fibonacci(17));
    }
}
