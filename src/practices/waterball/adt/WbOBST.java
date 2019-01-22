package practices.waterball.adt;

import dsa.Utils;
import dsa.adt.Data;

import java.util.ArrayList;
import java.util.List;

public class WbOBST extends WbThreadBSTree {
    private int[][] roots;
    private double minAvg;

    public WbOBST(double[] p) {
        int n = p.length;
        List<Integer> insertionOrder = produceOptimalInsertionOrder(n, p);
        for (int node : insertionOrder)
            this.insert(new Data(node, Character.forDigit(node, 10)));
    }

    private List<Integer> produceOptimalInsertionOrder(int n, double p[]) {
        p = Utils.paddingZero(p, 0, 1);
        int[][] R = new int[n+1][n+1];
        double[][] W = new double[n+2][n+2];
        double[][] A = new double[n+2][n+2];

        for (int i = 1; i <= n; i++)
        {
            A[i][i] = W[i][i] = p[i];
            R[i][i] = (int) p[i];
        }

        int j;
        for(int l = 2; l <= n; l++) {
            for(int i = 1; i <= n-l+1; i++) {
                j = i+l-1;
                double minCost = Double.MAX_VALUE;
                int root = i;
                for(int k = i; k <= j; k++) {
                    double cost = p[k] + A[i][k-1] + A[k+1][j] + W[i][k-1] + W[k+1][j];
                    if (cost < minCost) {
                        minCost = cost;
                        root = k;
                    }
                }
                W[i][j] = p[root] + W[i][root-1] + W[root+1][j];
                A[i][j] = minCost + W[i][j];
                R[i][j] = root;
            }
        }

        return produceOptimalInsertionOrderFromRoot(R);
    }

    private List<Integer> produceOptimalInsertionOrderFromRoot(int[][] R){
        ArrayList<Integer> order = new ArrayList<>();
        int i = 1, j = R.length-1;
        int p = R[i][j];
        while (i != 0 && j != 0){
            order.add(p);
            p = R[i][j];
        }

        return order;
    }
}

