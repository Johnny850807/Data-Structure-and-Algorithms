import dsa.algorithms.OtherAlgorithms;
import org.junit.Assert;
import org.junit.Test;
import practices.waterball.algorithms.WbOtherAlgorithms;

public class OtherAlgorithmsTest {
    private OtherAlgorithms otherAlgorithms = new WbOtherAlgorithms();  //replace it with yours

    @Test
    public void testMaximumArraySum(){
        int[] nums = {0, 1, 2, 3, -8, 7, 1, 5, -11, 12, 13, -25, 26};
        Assert.assertEquals(28, otherAlgorithms.maximumArraySum(nums));
    }
}
