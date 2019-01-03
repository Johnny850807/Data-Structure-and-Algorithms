package dsa.adt;

import java.util.Objects;
import java.util.TreeSet;

/**
 * Undirected graph
 */
public interface Graph {
    public static class Node {
        public int i;
        public int w;
        public Node(int i){
            this(i, 0);
        }
        public Node(int i, int w) {
            this.i = i;
            this.w = w;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return i == node.i &&
                    w == node.w;
        }

        @Override
        public int hashCode() {

            return Objects.hash(i, w);
        }
    }

    public static class Edge{
        public int v1;
        public int v2;
        public int w;

        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return v1 == edge.v1 &&
                    v2 == edge.v2 &&
                    w == edge.w;
        }

        @Override
        public int hashCode() {

            return Objects.hash(v1, v2, w);
        }
    }

    int getSize();
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

    TreeSet<Node>[] adjacencyList();
    int[][] adjacencyMatrix();

    /**
     * @param s source node's number
     * @return Ascending DFS order
     */
    int[] DFS(int s);

    /**
     * @param s source node's number
     * @return Ascending BFS order
     */
    int[] BFS(int s);
    boolean isCyclic();
    boolean isConnected();
    Edge[] kruskalMSP();
    Edge[] primMSP(int s);

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
