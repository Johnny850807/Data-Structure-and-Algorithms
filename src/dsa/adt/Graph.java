package dsa.adt;

import java.util.LinkedList;
/**
 * Adjacency-list graph
 */
public interface Graph {
    /**
     * set the number of nodes in the graph. All nodes will be designated a number from 1, 2, ..., n
     * @param n the number of nodes in the graph
     */
    void setSize(int n);

    /**
     * Add an edge to the graph, you should add the new edge into the adjacency list of vertex v1's
     * @param v1 source node's number
     * @param v2 target node's number
     */
    void addEdge(int v1, int v2, int weight);

    LinkedList<Integer>[] adjacencyList();
    int[][] getAdjacencyMatrix();

    /**
     * @return Recursive Ascending DFS order
     */
    int[] R_DFS();

    /**
     * @return Non-recursive Ascending DFS order
     */
    int[] NR_DFS();

    /**
     * @return Ascending BFS order
     */
    int[] BFS();
    boolean isCyclic();

    int[] kruskalMSP();
    int[] primMSP();

    /***
     * @param s source node's number
     * @param t target node's number
     * @return path
     */
    int[] dijkstraShortestPath(int s, int t);

    /**
     * @return all pair shortest path matrix
     */
    int[][] floydWarshallShortestPath();

    int[][] transitiveClosure();
}
