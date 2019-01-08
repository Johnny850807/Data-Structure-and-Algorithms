package practices.waterball.adt;

import dsa.Utils;
import dsa.adt.Data;
public class WbOBST extends WbThreadBSTree {
    private int[][] roots;
    private double minAvg;

    public WbOBST(double[] p) {
        int n = p.length;
        int[] insertionOrder = produceOptimalInsertionOrder(n, p);
        for (int node : insertionOrder)
            this.insert(new Data(node, Character.forDigit(node, 10)));
    }

    private int[] produceOptimalInsertionOrder(int n, double p[]) {
        int[][] R = new int[n+1][n+1];
        double[][] A = new double[n+1][n+1];
        p = Utils.paddingZero(p, 0, 1);

        /**
         * //todo DP
         */
        return produceOptimalInsertionOrderFromRoot(R);
    }

    private int[] produceOptimalInsertionOrderFromRoot(int[][] R){
        return new int[]{/*TODO*/};
    }
}

