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

    /**
     * @param matrices matrix's representation e.g. A x B would give you {"A", "B"}
     * @param p length of matrices, if A is a mxn matrix, and its the first matrix whose index is 0, then p[0] = m, p[1] = n
     */
    MatrixChainAnswer matrixChainMultiplication(String[] matrices, int[] p);

    public static class MatrixChainAnswer{
        public int numberOfMultiplications;
        public String matrixChain; // e.g. (A((B(CD))E))
    }

    /**
     * Dijkstra shortest path
     * @param adjacency the adjacency matrix of the graph
     * @return the node numbers in order in the shortest path
     */
    List<Integer> dijkstraShortestPath(int[][] adjacency);
}
