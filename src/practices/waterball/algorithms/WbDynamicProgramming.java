package practices.waterball.algorithms;

import dsa.Utils;
import dsa.algorithms.DynamicProgramming;

import java.util.*;

@SuppressWarnings("ALL")
public class WbDynamicProgramming implements DynamicProgramming {

    @Override
    public KnapSackAnswer R_01knapsack(int w, int[] vs, int[] ws){
        int n = vs.length;
        int[][] kp = new int[n+1][w+1];
        HashSet<Integer>[][] takenRecords = new HashSet[n+1][w+1];
        vs = padddingZero(vs, 0, 1);  // e.g. [1, 2, 2] => [0, 1, 2, 2]
        ws = padddingZero(ws, 0, 1);

        for (int k = 0; k <= w; k ++)
        {
            kp[0][k] = 0;
            takenRecords[0][k] = new HashSet<>();
        }

        for (int i = 1; i <= n; i ++)
        {
            kp[i][0] = 0;
            takenRecords[i][0] = new HashSet<>();
            for (int k = 1; k <= w; k ++)
            {
                if (k < ws[i]) //cannot take
                {
                    kp[i][k] = kp[i-1][k];
                    takenRecords[i][k] = cloneSet(takenRecords[i-1][k]);
                }
                else  //can take
                {
                    if(kp[i-1][k] >= vs[i]+kp[i-1][k-ws[i]])  //not taken is greater
                    {
                        kp[i][k] = kp[i-1][k];
                        takenRecords[i][k] = cloneSet(takenRecords[i-1][k]);
                    }
                    else  //taken is greater
                    {
                        kp[i][k] = vs[i]+kp[i-1][k-ws[i]];
                        takenRecords[i][k] = cloneSet(takenRecords[i-1][k-ws[i]]);
                        takenRecords[i][k].add(i);  //put it into the knapsack
                    }
                }
            }
        }
        System.out.println("Knapsack: ");
        System.out.println(Utils.tableToString(kp, 4));
        System.out.println("===================");
        System.out.println(Utils.tableToString(takenRecords, 5));
        System.out.println("===================");
        return new KnapSackAnswer(kp[n][w], takenRecords[n][w]);
    }

    @Override
    public int[] longestCommonSubsequence(int[] s1, int[] s2) {
        int[][] lcsTable = new int[s1.length+1][s2.length+1];
        int[][] previousTable = new int[s1.length+1][s2.length+1];  // record previous node
        s1 = padddingZero(s1, 0, 1);
        s2 = padddingZero(s2, 0, 1);

        for (int i = 1; i < s1.length; i ++)
            for (int j = 1; j < s2.length; j ++)
            {
                if (s1[i] == s2[j])
                {
                    lcsTable[i][j] = lcsTable[i-1][j-1] + 1;
                    previousTable[i][j] = 0;  //from the top left corner
                }
                else
                {
                    if (lcsTable[i][j-1] > lcsTable[i-1][j])
                    {
                        lcsTable[i][j] = lcsTable[i][j-1];
                        previousTable[i][j] = -1;  // from top
                    }
                    else
                    {
                        lcsTable[i][j] = lcsTable[i-1][j];
                        previousTable[i][j] = 1;  // from left
                    }
                }
            }

        return produceLongestCommonSequence(lcsTable, previousTable, s1);
    }

    @Override
    public int[] longestCommonString(int[] s1) {
        return null;
    }

    @Override
    public int[] longestIncreasingSequence(int[] s1) {
        WbSorter wbSorter = new WbSorter();
        int[] y = Arrays.copyOf(s1, s1.length);
        wbSorter.R_quickSort(y, 0, y.length-1);
        return longestCommonSubsequence(s1, y);
    }

    @Override
    public MatrixChainAnswer matrixChainMultiplication(String[] matrices, int[] p) {
        int n = p.length - 1;
        int[][] m = new int[n][n];

        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;

            }
        }

        return null;
    }

    private String optimalParensToString(int[] s){
        return optimalParensToString(s, 0, s.length-1).toString();
    }

    private StringBuilder optimalParensToString(int[] s, int i, int j){
        return null;
    }

    private int[] produceLongestCommonSequence(int[][] lcsTable, int[][] previousTable, int[] s1){
        int i = previousTable.length - 1;
        int j = previousTable[0].length - 1;
        int lcsLength = lcsTable[i][j];
        int[] lcs = new int[lcsLength];

        while(lcsLength > 0)
        {
            if (previousTable[i][j] == 0) // top left corner
            {
                lcs[--lcsLength] = s1[i];
                i--;
                j--;
            }

            else if (previousTable[i][j] == 1) // top
                i--;
            else if (previousTable[i][j] == -1) //left
                j--;
        }

        return lcs;
    }

    @Override
    public List<Integer> dijkstraShortestPath(int[][] adjacency) {
        return null;
    }

    private HashSet<Integer> cloneSet(HashSet<Integer> set){
        return (HashSet<Integer>) set.clone();
    }

    private int[] padddingZero(int[] array, int index, int length){
        int[] p = new int[array.length+length];
        for (int i = 0; i < length; i ++)
            p[i] = 0;
        for (int i = length; i < p.length; i ++)
            p[i] = array[i-length];
        return p;
    }
}
