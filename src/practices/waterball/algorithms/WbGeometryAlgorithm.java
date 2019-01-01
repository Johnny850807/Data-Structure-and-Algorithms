package practices.waterball.algorithms;

import dsa.adt.GeometryAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class WbGeometryAlgorithm implements GeometryAlgorithm {

    @Override
    public HashMap<Point, Integer> findRanks(List<Point> s) {
        HashMap<Point, Integer> rankMap = new HashMap<>();
        findRanks(rankMap, s, 0, s.size() - 1);
        return rankMap;
    }

    private void findRanks(HashMap<Point, Integer> rankMap, List<Point> points, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            int xMedian = points.get(m).x;
            List<Point> leftPoints = new ArrayList<>();
            List<Point> rightPoints = new ArrayList<>();

            for (int i = l; i <= r; i++) {
                if (points.get(i).x <= m)
                    leftPoints.add(points.get(i));
                else
                    rightPoints.add(points.get(i));
            }

            findRanks(rankMap, points, l, m);
            findRanks(rankMap, points, m + 1, r);

        } else
            rankMap.put(points.get(l), 0);  //put rank as 0 as terminating condition
    }

    @Override
    public Set<Point> maximalPoints(List<Point> s) {
        return null;
    }

    @Override
    public int closestPairs(List<Point> s) {
        return 0;
    }
}
