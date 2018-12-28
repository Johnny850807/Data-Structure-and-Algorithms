package dsa.adt;

public interface Graph {
    int[] DFS();
    int[] BFS();
    boolean isCyclic();
    int[][] getAdjacencyMatrix();
    EdgeCategory getEdgeCatgory(int u, int v);

    public enum EdgeCategory {
        TREE_EDGE, BACK_EDGE, FORWARD_EDGE, CROSS_EDGE
    }


    public class Edge{
        public int u;
        public int v;
        public boolean directed;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        public static Edge undirectedEdge(int u, int v){
            return new Edge(u, v);
        }

        public static Edge directedEdge(int u, int v){
            Edge e = new Edge(u, v);
            e.directed = true;
            return e;
        }
    }
}
