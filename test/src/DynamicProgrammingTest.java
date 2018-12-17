import dsa.algorithms.DynamicProgramming;
import org.junit.Test;
import practices.waterball.algorithms.WbDynamicProgramming;

import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

public class DynamicProgrammingTest {
    DynamicProgramming dynamicProgramming = new WbDynamicProgramming();  //replace it with yours

    @Test
    public void testLCS(){
        int[] s1 = IntStream.range(1, 50).filter(n -> n % 3 == 0).toArray();
        int[] s2 = IntStream.range(1, 50).filter(n -> n % 2 == 0).toArray();

        // the lcs would be all multiple numbers of 2 and 3, which can be divided by 6
        int[] lcs = IntStream.range(1, 50).filter(n -> n % 6 == 0).toArray();
        assertArrayEquals(lcs, dynamicProgramming.longestCommonSequence(s1, s2));
    }
}
