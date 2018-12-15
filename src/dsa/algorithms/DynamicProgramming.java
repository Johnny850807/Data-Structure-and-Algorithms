package dsa.algorithms;

import java.util.List;

public interface DynamicProgramming {

    /**
     * @param n select from 1 ~ n th items
     * @param w the remaining space size of the knapsack
     * @return
     */
    int R_01knapsack(int n, int w);

    /**
     * @return lsc(s1, s2)
     */
    int[] longestCommonSequence(int[] s1, int[] s2);


    /**
     * Dijkstra shortest path
     * @param adjacency the adjacency matrix of the graph
     * @return the node numbers in order in the shortest path
     */
    List<Integer> dijkstraShortestPath(int[][] adjacency);
}
