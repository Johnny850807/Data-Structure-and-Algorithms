package dsa.adt;

import java.util.*;
import java.util.HashMap;

public interface GeometryAlgorithm {
    /**
     * @param s set of all points sorted by their y value
     * @return ranks map <Point, Rank>
     */
    HashMap<Point, Integer> findRanks(List<Point> s);

    public static class RanksAnswer{
        HashMap<Point, Integer> ranks = new HashMap<>();
    }

    /**
     * @param s set of all points sorted by their y value
     * @return SET of all maximal points
     */
    Set<Point> maximalPoints(List<Point> s);

    /**
     * @param s set of all points sorted by their y value
     * @return the closest distance
     */
    int closestPairs(List<Point> s);

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)", x, y);
        }
    }
}
