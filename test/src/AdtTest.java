import dsa.adt.AdtFactory;
import dsa.adt.Stack;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdtTest {
    AdtFactory adtFactory;

    @Test
    public void testStack(){
        Stack stack = adtFactory.createStack(10);
        stack.push(1).push(3).push(5).push(7).push(9);
        assertEquals(9, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(1, stack.pop());
    }

}
