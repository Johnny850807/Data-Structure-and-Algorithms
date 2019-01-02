package practices.waterball.algorithms;

import dsa.adt.DisjointSet;
import dsa.adt.Graph;
import practices.waterball.adt.WbArrayDisjointSet;

import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedList;

public class WbGraph implements Graph {
    private int n;
    private TreeSet<Node>[] adjacencyList;

    @Override
    public int getSize() {
        return n;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setSize(int n) {
        this.n = n;
        adjacencyList = new TreeSet[n+1];  //pad a zero into the first place and place nodes into 1~nth elements
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new TreeSet<>((o1, o2)-> o1.i - o2.i);
        }
    }

    @Override
    public void addEdge(int v1, int v2, int weight) {
        // Undirected graph
        adjacencyList[v1].add(new Node(v2, weight));
        adjacencyList[v2].add(new Node(v1, weight));
    }

    public Set<Edge> getEdges(){
        HashSet<Edge> edges = new HashSet<>();
        for (int i = 1; i <= n; i ++) {
            for (Node node : adjacencyList[i])
            {
                int v1 = i;
                int v2 = node.i;
                if (!edges.contains(new Edge(v2, v1, node.w)))
                    edges.add(new Edge(v1, v2, node.w));
            }
        }
        return edges;
    }

    @Override
    public TreeSet<Node>[] adjacencyList() {
        return adjacencyList;
    }

    @Override
    public int[][] getAdjacencyMatrix() {
        int[][] m = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (Node node : adjacencyList[i]) {
                m[i][node.i] = node.w;
            }
        }
        return m;
    }

    private class TraversalStates {
        private final static int WHITE = 1;
        private final static int GRAY = 2;
        private final static int BLACK = 3;
        int time;
        int[] parent = new int[n+1];
        int[] finishTime = new int[n+1];
        int[] d = new int[n+1];  //discover time or distance
        int[] color = new int[n+1];  //white=1, gray=2, black=3
        LinkedList<Integer> path = new LinkedList<>();
        boolean hasCycle = false;

        int[] pathToArray(){
            int[] pathArray = new int[path.size()];
            for (int i = 0; i < path.size(); i++)
                pathArray[i] = path.get(i);
            return pathArray;
        }
    }

    @Override
    public int[] DFS(int s) {
        return DFS(s, new TraversalStates());
    }

    public int[] DFS(int s, TraversalStates t){
        t.time = 1;

        for (int i = 1; i <= n; i++){
            t.color[i] = TraversalStates.WHITE;
            t.parent[i] = 0;
        }

        dfsVisit(s, t);
        return t.pathToArray();
    }

    private void dfsVisit(int v, TraversalStates t){
        t.path.add(v);
        t.d[v] = t.time ++;
        t.color[v] = TraversalStates.GRAY;

        for (Node node : adjacencyList[v]) {
            int u = node.i;
            if (t.color[u] == TraversalStates.WHITE)
            {
                t.parent[u] = u;
                dfsVisit(node.i, t);
            }
        }

        t.finishTime[v] = t.time ++;
        t.color[v] = TraversalStates.BLACK;
    }

    @Override
    public int[] BFS(int s) {
        TraversalStates t = new TraversalStates();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        for (int i = 0; i <= n; i++)
            t.color[i] = TraversalStates.WHITE;

        while (!queue.isEmpty())
        {
            int u = queue.poll();
            t.path.add(u);
            t.color[u] = TraversalStates.GRAY;
            t.d[u] = t.d[t.parent[u]] + 1;  //distance + 1 from its parent
            for (Node node : adjacencyList[u]) {
                int v = node.i;
                if (t.color[v] == TraversalStates.WHITE)
                {
                    t.color[v] = TraversalStates.GRAY;
                    queue.add(v);
                }
            }
        }

        return t.pathToArray();
    }

    @Override
    public boolean isCyclic() {
        TraversalStates t = new TraversalStates();

        for (int i = 1; i <= n; i++)
            t.color[i] = TraversalStates.WHITE;

        for (int i = 1; i <= n; i++) {
            if (checkCycleByDfsVisit(i, t))
                return true;
        }
        return false;
    }

    private boolean checkCycleByDfsVisit(int v, TraversalStates t){
        t.color[v] = TraversalStates.GRAY;

        for (Node node : adjacencyList[v]) {
            int u = node.i;
            if (t.color[u] == TraversalStates.WHITE)
            {
                t.parent[u] = v;
                checkCycleByDfsVisit(u, t);
            }
            else if (t.color[u] == TraversalStates.GRAY
                    && u != t.parent[v] && v != t.parent[u])
                return true;
        }

        return false;
    }

    @Override
    public boolean isConnected() {
        TraversalStates t = new TraversalStates();
        this.DFS(1, t);  //dfs from a node and see if (any vertex is not visited) => (not connected)
        for (int color : t.color) {
            if (color == TraversalStates.WHITE)
                return false;
        }
        return true;
    }

    @Override
    public Edge[] kruskalMSP() {
        DisjointSet disjointSet = new WbArrayDisjointSet(n+1);
        for (int i = 1; i <= n; i++) {
            disjointSet.put(i, i);  //init a set per node
        }

        LinkedList<Edge> sortedEdges = new LinkedList<>(getEdges());
        sortedEdges.sort((e1, e2) -> e1.w - e2.w);

        Edge[] msp = new Edge[n-1];
        int mspCount = 0;
        for (Edge edge : sortedEdges) {
            int set1 = disjointSet.find(edge.v1);
            int set2 = disjointSet.find(edge.v2);
            if (set1 != set2)
            {
                msp[mspCount++] = edge;
                disjointSet.union(set1, set2);
            }
        }

        return msp;
    }

    @Override
    public Edge[] primMSP() {
        return new Edge[0];
    }

    @Override
    public int[] dijkstraShortestPath(int s, int t) {
        return new int[0];
    }

    @Override
    public int[][] floydWarshallShortestPath() {
        return new int[0][];
    }

    @Override
    public int[][] transitiveClosure() {
        return new int[0][];
    }
}
