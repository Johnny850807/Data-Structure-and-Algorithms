package practices.waterball.algorithms;

import dsa.algorithms.OtherAlgorithms;

public class WbOtherAlgorithms implements OtherAlgorithms {

    @Override
    public int maximumArraySum(int[] nums) {
        int m = nums[0];
        int maximum = m;

        for (int i = 1; i < nums.length; i++) {
            m = Math.max(m + nums[i], 0);
            maximum = Math.max(m, maximum);
        }

        return maximum;
    }

    @Override
    public int celebrity(int n) {
        return 0;
    }
}
