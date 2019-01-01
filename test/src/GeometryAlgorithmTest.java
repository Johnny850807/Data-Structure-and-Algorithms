import dsa.adt.GeometryAlgorithm;
import dsa.adt.GeometryAlgorithm.Point;
import org.junit.Test;
import practices.waterball.algorithms.WbGeometryAlgorithm;
import java.util.*;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GeometryAlgorithmTest {
    private static Point p1 = new Point(1, 2);  //rank = 0
    private static Point p2 = new Point(3, 4);  //rank = 1
    private static Point p3 = new Point(4, 8);  //rank = 2 // maximal point
    private static Point p4 = new Point(6, 3);  //rank = 1 //closest pair (6, 3) - (7, 5) distance sqrt(5)
    private static Point p5 = new Point(7, 5);  //rank = 3
    private static Point p6 = new Point(9, 7);  //rank = 4 // maximal point
    private static Point p7 = new Point(10, 4); //rank = 2 // maximal point
    private static Point p8 = new Point(12, 1); //rank = 0 // maximal point
    private static int expectedClosestDistance = (int) Math.sqrt(Math.pow(6-7, 2) + Math.pow(3-5, 2));
    private static HashSet<Point> expectedMaximalPoints = new HashSet<>();
    private static HashMap<Point, Integer> expectedRankMap = new java.util.HashMap<>();
    /**
     * Points with comparator sorting by y values in the ascending order
     */
    private static TreeSet<Point> pointSet = new TreeSet<>((o1, o2) -> o2.y - o1.y);
    private static List<Point> sortedPointList;

    static {
        pointSet.add(p1);  //rank = 0
        pointSet.add(p2);  //rank = 1
        pointSet.add(p3);  //rank = 2 // maximal point
        pointSet.add(p4);  //rank = 1 //closest pair (6, 3) - (7, 5) distance sqrt(5)
        pointSet.add(p5);  //rank = 3
        pointSet.add(p6);  //rank = 4 // maximal point
        pointSet.add(p7);  //rank = 2 // maximal point
        pointSet.add(p8);  //rank = 0 // maximal point

        expectedRankMap.put(p1, 0);
        expectedRankMap.put(p2, 1);
        expectedRankMap.put(p3, 2);
        expectedRankMap.put(p4, 1);
        expectedRankMap.put(p5, 3);
        expectedRankMap.put(p6, 4);
        expectedRankMap.put(p7, 2);
        expectedRankMap.put(p8, 0);

        expectedMaximalPoints.add(p3);
        expectedMaximalPoints.add(p6);
        expectedMaximalPoints.add(p7);
        expectedMaximalPoints.add(p8);

        sortedPointList = new ArrayList<>(pointSet);
    }

    private GeometryAlgorithm geometryAlgorithm = new WbGeometryAlgorithm();  //replace it with yours

    @Test
    public void testFindRank(){
        HashMap<Point, Integer> rankMap = geometryAlgorithm.findRanks(sortedPointList);
        assertEquals(expectedRankMap, rankMap);
    }
    @Test
    public void testFindMaximalPoints(){
        Set<Point> maximalPoints = geometryAlgorithm.maximalPoints(sortedPointList);
        assertEquals(expectedMaximalPoints, maximalPoints);
    }
    @Test
    public void testFindClosestDistance(){
        int closestDistance = geometryAlgorithm.closestPairs(sortedPointList);
        assertEquals(expectedClosestDistance, closestDistance);
    }
}
