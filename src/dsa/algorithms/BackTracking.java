package dsa.algorithms;

import java.util.HashSet;
import java.util.List;

public interface BackTracking {

    HashSet<HashSet<Integer>> generatePowerSet(HashSet<Integer> set);

    /**
     * @param set the set where the combination come from
     * @param r r-combination is applied, i.e. the fixed size of generated subsets.
     */
    HashSet<HashSet<Integer>> generateCombinations(HashSet<Integer> set, final int r);

    /**
     * generate all possible tuple of the specific size r with numbers 1 ~ n
     * For example: the output for an input n=3, r=2 is:
     * {[1, 1], [1, 2], [1, 3], [2, 1], [2, 2], [2, 3], [3, 1], [3, 2], [3, 3]}
     */
    HashSet<Integer[]> generateTuples(int n, int r);


    /**
     * generate all possible tuple of the specific size r with numbers 1 ~ n
     * For example: the output for an input n=3, r=2 is:
     * {[1, 2], [1, 3], [2, 1], [2, 3], [3, 1], [3, 2]}
     */
    HashSet<Integer[]> generatePermutations(int n, int r);

    HashSet<Integer[]> generatePermutations(Integer[] nums);

    public enum Direction{
        U(0, -1),
        D(0, 1),
        L(-1, 0),
        R(1, 0);

        public int dx;
        public int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    /**
     * @param maze The 5x5 maze to be solved, it contains only 0 and 1 as entries. '0' denotes walkable block and '1' denotes barrier.
     *             The origin of the maze is at (0, 0), and the goal is at (4, 4)
     * @return The solution of the path from (0, 0) to (4, 4) contains a series of moving direction
     */
    List<Direction> solveMaze(int[][] maze);

    default void swap(Integer[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
