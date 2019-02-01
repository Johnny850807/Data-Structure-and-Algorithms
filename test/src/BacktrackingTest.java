import dsa.Utils;
import dsa.algorithms.BackTracking;
import dsa.algorithms.BackTracking.Direction;
import org.junit.Test;
import practices.waterball.algorithms.WbBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BacktrackingTest {
    private BackTracking backTracking = new WbBacktracking();  //replace it with yours


    @Test
    public void testPowerSet() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        int[][] expectedPowerSetArray = {{}, {1}, {2}, {3}, {1, 2}, {2, 3}, {1, 3}, {1, 2, 3}};
        HashSet<HashSet<Integer>> expectedPowerSet = new HashSet<>();
        for (int i = 0; i < expectedPowerSetArray.length; i++) {
            HashSet<Integer> subset = new HashSet<>();
            for (int j = 0; j < expectedPowerSetArray[i].length; j++) {
                subset.add(expectedPowerSetArray[i][j]);
            }
            expectedPowerSet.add(subset);
        }

        HashSet<HashSet<Integer>> actualPowerSet = backTracking.generatePowerSet(set);
        System.out.println("Power set of {1,2,3} = \n" + Utils.setToString(actualPowerSet));
        for (HashSet<Integer> subset : expectedPowerSet) {
            assertTrue(actualPowerSet.contains(subset));
        }

    }

    @Test
    public void testGenerateCombinations() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        int[][] expectedSubsetArray = {{1, 2}, {1, 3}, {2, 3}};
        HashSet<HashSet<Integer>> expectedCombinations = new HashSet<>();
        for (int i = 0; i < expectedSubsetArray.length; i++) {
            HashSet<Integer> subset = new HashSet<>();
            for (int j = 0; j < expectedSubsetArray[i].length; j++) {
                subset.add(expectedSubsetArray[i][j]);
            }
            expectedCombinations.add(subset);
        }

        HashSet<HashSet<Integer>> actualCombinations = backTracking.generateCombinations(set, 2);
        System.out.println("2-Combinations of {1,2,3} = \n" + Utils.setToString(actualCombinations));
        for (HashSet<Integer> subset : expectedCombinations) {
            assertTrue(actualCombinations.contains(subset));
        }
    }

    @Test
    public void testGenerateTuples() {
        HashSet<Integer[]> expected = new HashSet<>();
        expected.add(new Integer[]{1, 1});
        expected.add(new Integer[]{1, 2});
        expected.add(new Integer[]{1, 3});
        expected.add(new Integer[]{2, 1});
        expected.add(new Integer[]{2, 2});
        expected.add(new Integer[]{2, 3});
        expected.add(new Integer[]{3, 1});
        expected.add(new Integer[]{3, 2});
        expected.add(new Integer[]{3, 3});

        HashSet<Integer[]> actual = backTracking.generateTuples(3, 2);
        for (Integer[] mtp : expected) {
            assertTrue(actual.stream().anyMatch(tp -> Arrays.equals(tp, mtp)));
        }

    }

    @Test
    public void testGenerateRPermutations() {
        HashSet<Integer[]> expected = new HashSet<>();
        expected.add(new Integer[]{1, 2});
        expected.add(new Integer[]{1, 3});
        expected.add(new Integer[]{2, 1});
        expected.add(new Integer[]{2, 3});
        expected.add(new Integer[]{3, 1});
        expected.add(new Integer[]{3, 2});

        HashSet<Integer[]> actual = backTracking.generatePermutations(3, 2);
        for (Integer[] perm : expected) {
            assertTrue(actual.stream().anyMatch(p -> Arrays.equals(p, perm)));
        }
    }

    @Test
    public void testGeneratePermutations() {
        Integer[] nums = {1, 2, 3};
        HashSet<Integer[]> expected = new HashSet<>();
        expected.add(new Integer[]{1, 2, 3});
        expected.add(new Integer[]{1, 3, 2});
        expected.add(new Integer[]{2, 1, 3});
        expected.add(new Integer[]{2, 3, 1});
        expected.add(new Integer[]{3, 1, 2});
        expected.add(new Integer[]{3, 2, 1});

        HashSet<Integer[]> actual = backTracking.generatePermutations(nums);
        for (Integer[] perm : expected) {
            assertTrue(actual.stream().anyMatch(p -> Arrays.equals(p, perm)));
        }
    }

    @Test
    public void testMazeSolving() {
        int[][] maze = new int[][]{
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0}
        };

        List<Direction> expectedPath = new ArrayList<>();
        expectedPath.add(Direction.D);
        expectedPath.add(Direction.D);
        expectedPath.add(Direction.D);
        expectedPath.add(Direction.R);
        expectedPath.add(Direction.R);
        expectedPath.add(Direction.U);
        expectedPath.add(Direction.U);
        expectedPath.add(Direction.U);
        expectedPath.add(Direction.R);
        expectedPath.add(Direction.R);
        expectedPath.add(Direction.D);
        expectedPath.add(Direction.D);
        expectedPath.add(Direction.D);
        expectedPath.add(Direction.D);

        List<Direction> path = backTracking.solveMaze(maze);
        assertEquals(expectedPath, path);
    }
}
