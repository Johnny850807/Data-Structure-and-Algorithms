package practices.waterball.algorithms;

import dsa.Utils;
import dsa.Utils.PrioritySet;
import dsa.adt.DisjointSet;
import dsa.adt.Graph;
import practices.waterball.adt.WbDisjointSet;

import java.util.*;

import static dsa.Utils.intListToArray;
import static java.lang.Math.min;

public class WbGraph implements Graph, Cloneable{
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

    /**
     * @return new node's number
     */
    @SuppressWarnings("unchecked")
    public int addNode(){
        TreeSet<Node>[] newAdjList = new TreeSet[n+2];
        System.arraycopy(this.adjacencyList, 1, newAdjList, 1, n);  //copy the old adj lists
        newAdjList[n+1] = new TreeSet<>((o1, o2)-> o1.i - o2.i);  // addEdition a new adj list for the new node
        this.adjacencyList = newAdjList;  //set the new adj list back
        return ++n;  //plus 1 and return the new node's number
    }

    @Override
    public void addEdge(int v1, int v2, int weight) {
        // Undirected graph
        adjacencyList[v1].add(new Node(v2, weight));
        adjacencyList[v2].add(new Node(v1, weight));
    }

    public Set<Edge> getUndirectedEdges(){
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


    public Set<Edge> getDirectedEdges(){
        HashSet<Edge> edges = new HashSet<>();
        for (int i = 1; i <= n; i ++) {
            for (Node node : adjacencyList[i])
                edges.add(new Edge(i, node.i, node.w));
        }
        return edges;
    }

    @Override
    public TreeSet<Node>[] adjacencyList() {
        return adjacencyList;
    }

    @Override
    public int[][] adjacencyMatrix() {
        int[][] m = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    m[i][j] = 0;  //self to self
                else
                    m[i][j] = Integer.MAX_VALUE;  //Infinity weight as default
            }
        }

        for (int i = 1; i <= n; i++) {  //update adjacent nodes with their weights
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
                    && u != t.parent[v] && v != t.parent[u])  //check if u and v have no relation to each other
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

    @Override  //O(nLgn)
    public Edge[] kruskalMSP() {
        DisjointSet disjointSet = new WbDisjointSet(n+1);

        LinkedList<Edge> sortedEdges = new LinkedList<>(getUndirectedEdges());
        sortedEdges.sort((e1, e2) -> e1.w - e2.w);  //O(nLgn)

        Edge[] msp = new Edge[n-1];
        int mspCount = 0;
        while (!sortedEdges.isEmpty()) {  //O(e)
            Edge minEdge = sortedEdges.pollFirst();  //O(1)
            int set1 = disjointSet.find(minEdge.v1);
            int set2 = disjointSet.find(minEdge.v2);
            if (set1 != set2)
            {
                msp[mspCount++] = minEdge;
                disjointSet.union(set1, set2);
            }
        }

        return msp;
    }

    @Override
    public Edge[] primMSP(int s) {
        int[] key = new int[n+1];
        Node[] parents = new Node[n+1];
        PrioritySet<Integer> Q = new PrioritySet<>((v1, v2)-> {
            if (key[v1] != key[v2])
                return key[v1] - key[v2];
            return v1 - v2;
        });  //sorted by their key

        for (int i = 1; i <= n; i++) {
            key[i] = Integer.MAX_VALUE;
            Q.add(i);
        }
        key[s] = 0; //origin
        Q.updateKey(s);

        while (!Q.isEmpty())
        {
            int u = Q.extractMin();
            for (Node node : adjacencyList[u]) {
                int v = node.i;
                if (Q.contains(v) && node.w < key[v])
                {
                    parents[v] = new Node(u, node.w);
                    key[v] = node.w;
                    Q.updateKey(v);
                }
            }
        }

        Edge[] msp = new Edge[n-1];
        int mspCount = 0;
        for (int i = 1; i <= n; i++) {
            int child = i;  //padding index off 1
            Node parent = parents[child];
            if (parent != null)
                msp[mspCount++] = new Edge(parent.i, child, parent.w);
        }
        return msp;
    }

    @Override
    public ShortestPathResult dijkstraShortestPath(int s, int t) {
        int[] parent = new int[n+1];
        int[][] adjMatrix = adjacencyMatrix();
        long[] D = new long[n+1];  //distances  //we need long to contain value higher than Int.max
        PrioritySet<Integer> Q = new PrioritySet<>((v1, v2) -> {
            if (D[v1] != D[v2])
                return (int) (D[v1] - D[v2]);
            return v1 - v2;
        }); //sorted by their distances

        for (int i = 1; i <= n; i++)
        {
            D[i] = adjMatrix[s][i];
            if (D[i] != Integer.MAX_VALUE)
                parent[i] = s;
            Q.add(i);
        }

        while (!Q.isEmpty()){
            int u = Q.extractMin();
            for (Node node : adjacencyList[u]) {
                int v = node.i;
                if (D[u] + adjMatrix[u][v] < D[v]){
                    D[v] = D[u] + adjMatrix[u][v];
                    Q.updateKey(v);
                    parent[v] = u;
                }
            }
        }

        return new ShortestPathResult(backtrackPathFromParents(s, t, parent), D);
    }


    public ShortestPathResult bellmanFordShortestPath(int s, int t){
        int[] parent = new int[n+1];
        int[][] adjMatrix = adjacencyMatrix();
        long[] D = new long[n+1];  //distances //we need long to contain value higher than Int.max
        Set<Edge> edges = getDirectedEdges();

        for (int i = 1; i <= n; i++) {
            D[i] = i == s ? 0 : Integer.MAX_VALUE;
        }

        for (int k = 1; k <= n-1; k++) {
            for (Edge edge : edges) {
                int u = edge.v1;
                int v = edge.v2;
                if (D[u] + adjMatrix[u][v] < D[v]){
                    D[v] = D[u] + adjMatrix[u][v];
                    parent[v] = u;
                }
            }
        }

        for (Edge edge : edges) {
            int u = edge.v1;
            int v = edge.v2;
            if (D[u] + adjMatrix[u][v] < D[v]) {
                throw new NegativeCycleException();
            }
        }

        return new ShortestPathResult(backtrackPathFromParents(s, t, parent), D);
    }

    @Override
    public long[][] floydWarshallShortestPath() {
        long[][] D = new long[n+1][n+1];  //take off the offset now to fit the answer
        int[][] adjMatrix = adjacencyMatrix();
        int[][] parents = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && adjMatrix[i][j] != Integer.MAX_VALUE)
                    parents[i][j] = i;
                D[i][j] = adjMatrix[i][j];
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (D[i][j] > D[i][k] + D[k][j]){
                        D[i][j] = D[i][k] + D[k][j];
                        parents[i][j] = parents[k][j];
                    }
                }
            }
        }

        return D;
    }

    private int[] backtrackPathFromParents(int sourceNode, int targetNode, int[] parent){
        LinkedList<Integer> path = new LinkedList<>();
        int nodeIdx = targetNode; //start from the target node
        path.addFirst(targetNode);
        while (nodeIdx != sourceNode) //until tracked back to the origin
        {
            path.addFirst(parent[nodeIdx]);
            nodeIdx = parent[nodeIdx];
        }
        return intListToArray(path);
    }

    @Override
    public int[][] transitiveClosure() {
        int[][] T = new int[n+1][n+1];  //take off the offset now to fit the answer
        int[][] adjMatrix = adjacencyMatrix();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (adjMatrix[i][j] != Integer.MAX_VALUE)
                    T[i][j] = 1;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    T[i][j] |= T[i][k] & T[k][j];
                }
            }
        }

        return T;
    }

    @Override
    public long[][] johnsonShortestPath() {
        WbGraph graph = this.clone();  //to avoid change to the original graph, clone a new one

        //(1) addEdition a new node s with 0 weight incident to each node : O(V)
        int s = graph.addNode();
        for (int i = 1; i <= n; i++) {
            graph.addEdge(s, i, 0) ;
        }

        //(2) Use BellmanFord to compute the shortest path from s to each node, stored in h : O(VE)
        long[] h = graph.bellmanFordShortestPath(s, n).D;

        graph = this.clone(); //clone again to remove the s node
        //(3) Reweight by w(u,v) = w(u, v) + h(u) - h(v) : O(E)
        for (int i = 1; i <= n; i++) {
            for (Node node : graph.adjacencyList[i]) {
                node.w = (int) (node.w + h[i] - h[node.i]);
            }
        }

        //(4) Compute all-pair Dijkstra : O(V(E + VlgV)) = O(VE + V^2lgV)
        long[][] D = new long[n+1][n+1];
        for (int i = 1; i <= n; i++)
            D[i] = graph.dijkstraShortestPath(i, n).D;

        return D;
    }

    @SuppressWarnings("unchecked")
    protected WbGraph clone(){
        try {
            WbGraph clone = (WbGraph) super.clone();
            clone.adjacencyList = new TreeSet[n+1];
            for (int i = 1; i <= n; i++) {
                clone.adjacencyList[i] = new TreeSet<>((o1, o2)-> o1.i - o2.i);
                for (Node node : adjacencyList[i]) {
                    clone.adjacencyList[i].add(node);
                }
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new Error();
        }
    }

}
