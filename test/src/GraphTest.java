import dsa.adt.Graph;
import dsa.adt.Graph.Edge;
import org.junit.Before;
import org.junit.Test;
import practices.waterball.algorithms.WbGraph;

import static org.junit.Assert.*;

public class GraphTest {
    private Graph cyclicConnectedGraph1 = new WbGraph();  //replace it with yours
    private Graph acyclicDisconnectedGraph2 = new WbGraph();  //replace it with yours
    private Graph negativeCyclicGraph3 = new WbGraph();  //replace it with yours
    private int mspWeightGraph1;
    private int[] shortestPathGraph1;
    private int[][] transitiveClosureGraph2;

    @Before
    public void before(){
        cyclicConnectedGraph1.setSize(10);
        cyclicConnectedGraph1.addEdge(1, 2, 3);
        cyclicConnectedGraph1.addEdge(1, 3, 5);
        cyclicConnectedGraph1.addEdge(2, 4, 1);
        cyclicConnectedGraph1.addEdge(2, 5, 2);
        cyclicConnectedGraph1.addEdge(3, 6, 4);
        cyclicConnectedGraph1.addEdge(3, 4, 5);
        cyclicConnectedGraph1.addEdge(4, 8, 18);
        cyclicConnectedGraph1.addEdge(6, 7, 2);
        cyclicConnectedGraph1.addEdge(6, 9, 20);
        cyclicConnectedGraph1.addEdge(5, 8, 15);
        cyclicConnectedGraph1.addEdge(5, 7, 8);
        cyclicConnectedGraph1.addEdge(8, 9, 1);
        cyclicConnectedGraph1.addEdge(8, 10, 15);
        cyclicConnectedGraph1.addEdge(9, 10, 1);
        cyclicConnectedGraph1.addEdge(7, 9, 1);
        cyclicConnectedGraph1.addEdge(7, 10, 2);  //to see what cyclicConnectedGraph1 built here, see 圖論程式測資.png

        mspWeightGraph1 = 20;
        shortestPathGraph1 = new int[]{1, 3, 6, 7, 10};

        acyclicDisconnectedGraph2.setSize(11);
        acyclicDisconnectedGraph2.addEdge(1, 2, 1);
        acyclicDisconnectedGraph2.addEdge(1, 3, 1);
        acyclicDisconnectedGraph2.addEdge(1, 4, 1);
        acyclicDisconnectedGraph2.addEdge(3, 5, 1);
        acyclicDisconnectedGraph2.addEdge(5, 6, 1);
        acyclicDisconnectedGraph2.addEdge(5, 7, 1);
        acyclicDisconnectedGraph2.addEdge(9, 10, 1);
        acyclicDisconnectedGraph2.addEdge(9, 11, 1);

        transitiveClosureGraph2 = new int[][]{
                        /*0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11*/
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},  // 0 empty
                new int[]{0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                new int[]{0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                new int[]{0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                new int[]{0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                new int[]{0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                new int[]{0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                new int[]{0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}
        };

        negativeCyclicGraph3.setSize(6);
        negativeCyclicGraph3.addEdge(1, 2, 1);
        negativeCyclicGraph3.addEdge(2, 3, 1);
        negativeCyclicGraph3.addEdge(3, 4, 1);
        negativeCyclicGraph3.addEdge(4, 5, 1);
        negativeCyclicGraph3.addEdge(5, 6, 1);
        negativeCyclicGraph3.addEdge(6, 1, 1);
        negativeCyclicGraph3.addEdge(2, 5, -5);
        negativeCyclicGraph3.addEdge(3, 6, 2);
    }

    @Test
    public void testGraphTraversal(){
        //from the source - node 1
        int[] dfsAnswer = {1, 2, 4, 3, 6, 7, 5, 8, 9, 10};
        int[] bfsAnswer = {1, 2, 3, 4, 5, 6, 8, 7, 9, 10};
        int[] rdfs = cyclicConnectedGraph1.DFS(1);
        assertArrayEquals(dfsAnswer, rdfs);

        int[] bfs = cyclicConnectedGraph1.BFS(1);
        assertArrayEquals(bfsAnswer, bfs);
    }

    @Test
    public void testGraphCycleDetection(){
        assertTrue(cyclicConnectedGraph1.isCyclic()); //the cyclicConnectedGraph1 is cyclic
        assertFalse(acyclicDisconnectedGraph2.isCyclic());
    }

    @Test
    public void testGraphConnection(){
        assertTrue(cyclicConnectedGraph1.isConnected()); //the cyclicConnectedGraph1 is cyclic
        assertFalse(acyclicDisconnectedGraph2.isConnected());
    }

    @Test
    public void testKruskal(){
        assertGraph1MSTCorrect(cyclicConnectedGraph1.kruskalMSP());
    }

    @Test
    public void testPrim(){
        assertGraph1MSTCorrect(cyclicConnectedGraph1.primMSP(1));
    }
    private void assertGraph1MSTCorrect(Edge[] mst){
        assertEquals(mspWeightGraph1, getEdgeWeightSum(mst));
        assertAllNodesCovered(mst, cyclicConnectedGraph1.getSize());
    }

    private int getEdgeWeightSum(Edge[] edges){
        int sum = 0;
        for (Edge edge : edges) {
            sum += edge.w;
        }
        return sum;
    }

    private void assertAllNodesCovered(Edge[] edges, int n){
        boolean[] covered = new boolean[n+1];
        for (Edge edge : edges) {
            covered[edge.v1] = covered[edge.v2] = true;
        }
        for (int i = 1; i <= n; i ++) {
            assertTrue(covered[i]);
        }
    }

    @Test
    public void testDijkstraShortestPath(){
        int[] pathDijkstra = cyclicConnectedGraph1.dijkstraShortestPath(1, 10);
        assertArrayEquals(shortestPathGraph1, pathDijkstra);
    }

    @Test
    public void testBellmanFordShortestPath(){
        int[] pathBellmanFord = cyclicConnectedGraph1.bellmanFordShortestPath(1, 10);
        assertArrayEquals(shortestPathGraph1, pathBellmanFord);

        try {
            negativeCyclicGraph3.bellmanFordShortestPath(1, 4);
            fail();  //Not detecting negative cycle
        }catch (Graph.NegativeCycleException ignored){}
    }

    @Test
    public void testfloydWarshallShortestPath(){
        //cyclicConnectedGraph1.floydWarshallShortestPath();
    }


    @Test
    public void testTransitiveClosure(){
        assertArrayEquals(transitiveClosureGraph2, acyclicDisconnectedGraph2.transitiveClosure());
    }
}