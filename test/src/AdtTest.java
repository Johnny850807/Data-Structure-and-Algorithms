import dsa.adt.AdtFactory;
import dsa.adt.ArrayStack;
import dsa.adt.MultipleStack;
import dsa.adt.SingleStack;
import org.junit.Test;
import practices.waterball.adt.WbAdtFactory;

import static org.junit.Assert.*;

@SuppressWarnings("ALL")
public class AdtTest {
    AdtFactory adtFactory = new WbAdtFactory();  // replace the factory with yours

    @Test
    public void testStack(){
        assertStack(adtFactory.createArrayStack(1000), 1000, true);
        assertStack(adtFactory.createLinkedListStack(), -1, false);
    }


    private void assertStack(SingleStack stack, int maxSize, boolean hasSizeLimit){
        assertTrue(stack.isEmpty());

        for (int i = 1; i <= maxSize; i ++)
            stack.push(i);

        assertTrue(!hasSizeLimit ^ stack.isFull());

        for (int i = maxSize; i >= 1; i --)
            assertEquals(i, stack.pop());
    }

    @Test
    public void testMultipleStacks(){
        assertMultipleStack(adtFactory.createDoubleStack(1000), 500, 2);
       // assertMultipleStack(adtFactory.createMultipleStack(1000), 500, 10);
    }


    private void assertMultipleStack(MultipleStack stack, int stackSize, int stackCount){
        for (int n = 0; n < stackCount; n ++)
        {
            assertTrue(stack.isEmpty(n));

            for (int i = 1; i <= stackSize; i ++)
                stack.push(n, i);
        }

        for (int n = 0; n < stackCount; n ++)
            assertTrue(stack.isFull(n));

        for (int n = 0; n < stackCount; n ++)
        {
            for (int i = stackSize; i >= 1; i --)
                assertEquals(i, stack.pop(n));
        }
    }
}
