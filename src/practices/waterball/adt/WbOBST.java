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
        int j,diagonal;
        double [][]A = new double[n+2][n+2];

        for (int i=0; i<n; i++)
            A[i+1][i+1] = p[i];
        for(int i=0;i<=n;i++)
            R[i][i] = i;

        for(diagonal=1; diagonal <= n-1; diagonal++) {
            for(int i=1; i <= n-diagonal; i++) {
                j = i + diagonal;
                double minimum = Double.MAX_VALUE;
                double pm = 0;
                int minr = 0;
                for(int k=i; k<=j; k++) {
                    if (A[i][k-1] + A[k+1][j] < minimum) {
                        minimum = A[i][k-1]+A[k+1][j];
                        minr = k;
                    }
                    pm += p[k-1];
                }
                A[i][j] = minimum + pm;
                R[i][j] = minr;

                System.out.println();
            }
        }

        return produceOptimalInsertionOrderFromRoot(R);
    }

    private int[] produceOptimalInsertionOrderFromRoot(int[][] R){
        return new int[]{/*TODO*/};
    }
}

