import dsa.adt.AdtFactory;
import dsa.adt.Stack;
import org.junit.Assert;
import org.junit.Test;
import practices.waterball.adt.WbAdtFactory;

import static org.junit.Assert.*;

public class AdtTest {
    AdtFactory adtFactory = new WbAdtFactory();  // replace the factory with yours

    @Test
    public void testAdt(){
        assertStack(adtFactory.createArrayStack(1000), 1000, true);
        assertStack(adtFactory.createLinkedListStack(), -1, false);
    }


    private void assertStack(Stack stack, int maxSize, boolean hasSizeLimit){
        assertTrue(stack.isEmpty());

        for (int i = 1; i <= maxSize; i ++)
            stack.push(i);

        assertTrue(!hasSizeLimit ^ stack.isFull());

        for (int i = maxSize; i >= 1; i --)
            assertEquals(i, stack.pop());
    }



}
