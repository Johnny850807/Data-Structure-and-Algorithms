package practices.waterball.algorithms;

import dsa.Utils;
import dsa.algorithms.DynamicProgramming;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class WbDynamicProgramming implements DynamicProgramming {

    @Override
    public int R_01knapsack(int n, int w) {
        return 0;
    }

    @Override
    public int[] longestCommonSequence(int[] s1, int[] s2) {
        int[][] lcsTable = new int[s1.length+1][s2.length+1];
        int[][] previousTable = new int[s1.length+1][s2.length+1];  // record previous node


        for (int i = 1; i < s1.length+1; i ++)
            for (int j = 1; j < s2.length+1; j ++)
            {
                if (s1[i-1] == s2[j-1])
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

    private int[] produceLongestCommonSequence(int[][] lcsTable, int[][] previousTable, int[] s1){
        int i = previousTable.length - 1;
        int j = previousTable[0].length - 1;
        int lcsLength = lcsTable[i][j];
        int[] lcs = new int[lcsLength];

        while(lcsLength > 0)
        {
            if (previousTable[i][j] == 0) // top left corner
            {
                lcs[--lcsLength] = s1[i-1];
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
}
