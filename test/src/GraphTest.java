import dsa.adt.Graph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import practices.waterball.algorithms.WbGraph;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class GraphTest {
    private Graph graph = new WbGraph();  //replace it with yours

    @Before
    public void before(){
        graph.setSize(10);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 2);
        graph.addEdge(3, 6, 4);
        graph.addEdge(3, 4, 5);
        graph.addEdge(4, 8, 18);
        graph.addEdge(6, 7, 2);
        graph.addEdge(6, 9, 20);
        graph.addEdge(5, 8, 15);
        graph.addEdge(5, 7, 8);
        graph.addEdge(8, 9, 1);
        graph.addEdge(8, 10, 15);
        graph.addEdge(7, 9, 1);
        graph.addEdge(7, 10, 2);  //to see what graph built here, see 圖論程式測資.png
    }

    @Test
    private void testGraphTraversal(){
        //from the source - node 1
        int[] dfsAnswer = {1, 2, 4, 3, 6, 7, 5, 8, 9, 10};
        int[] bfsAnswer = {1, 2, 3, 4, 5, 6, 8, 7, 9, 10};
        int[] nrdfs = graph.NR_DFS();
        int[] rdfs = graph.R_DFS();
        assertArrayEquals(nrdfs, rdfs);
        assertArrayEquals(dfsAnswer, rdfs);

        int[] bfs = graph.BFS();
        assertArrayEquals(bfsAnswer, bfs);

        assertTrue(graph.isCyclic()); //the graph it cyclic
    }
}
