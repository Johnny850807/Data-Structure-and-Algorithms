package dsa.algorithms;

import java.util.HashSet;
import java.util.List;

public interface DynamicProgramming {

    /**
     * @param w total weight
     * @param vs each item's value
     * @param ws each item's weight
     */
    KnapSackAnswer R_01knapsack(int w, int[] vs, int[] ws);

    public static class KnapSackAnswer{
        public int maximalValue;
        public HashSet<Integer> takenItems;
        public KnapSackAnswer(int maximalValue, HashSet<Integer> takenItems) {
            this.maximalValue = maximalValue;
            this.takenItems = takenItems;
        }
    }

    int[] longestCommonSubsequence(int[] s1, int[] s2);

    int[] longestCommonString(int[] s1);

    int[] longestIncreasingSequence(int[] s1);

    int matrixChainMultiplication(int[] p);



    /**
     * Dijkstra shortest path
     * @param adjacency the adjacency matrix of the graph
     * @return the node numbers in order in the shortest path
     */
    List<Integer> dijkstraShortestPath(int[][] adjacency);
}
