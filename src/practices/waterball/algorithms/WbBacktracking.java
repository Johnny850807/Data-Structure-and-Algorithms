package practices.waterball.algorithms;

import dsa.algorithms.BackTracking;

import java.util.*;

public class WbBacktracking implements BackTracking{

    @Override
    public HashSet<HashSet<Integer>> generatePowerSet(HashSet<Integer> set) {
        return generatePowerSetRecursively(new ArrayList<>(set), 0, new boolean[set.size()], new HashSet<>());
    }

    private HashSet<HashSet<Integer>> generatePowerSetRecursively(ArrayList<Integer> nums, int k, boolean[] member, HashSet<HashSet<Integer>> powerSet){
        if (k >= nums.size())
        {
            HashSet<Integer> subset = new HashSet<>();
            for (int i = 0; i < member.length; i++) {
                if (member[i])
                    subset.add(nums.get(i));
            }
            powerSet.add(subset);
        }
        else
        {
            member[k] = true;
            generatePowerSetRecursively(nums, k+1, member, powerSet);
            member[k] = false;
            generatePowerSetRecursively(nums, k+1, member, powerSet);
        }
        return powerSet;
    }


    @Override
    public HashSet<HashSet<Integer>> generateCombinations(HashSet<Integer> set, final int r) {
        return generateCombinationsRecursively(new ArrayList<>(set), r, 0, 0, new boolean[set.size()], new HashSet<>());
    }

    public HashSet<HashSet<Integer>> generateCombinationsRecursively(ArrayList<Integer> nums,
                                                                     final int r, int k, int m, boolean[] member, HashSet<HashSet<Integer>> combinations) {
        if (m == r){
            HashSet<Integer> subset = new HashSet<>();
            for (int i = 0; i < member.length; i++) {
                if (member[i])
                    subset.add(nums.get(i));
            }
            combinations.add(subset);
        }
        else if (k < nums.size()){
            member[k] = true;
            generateCombinationsRecursively(nums, r, k+1, m+1, member, combinations);
            member[k] = false;
            generateCombinationsRecursively(nums, r, k+1, m, member, combinations);
        }

        return combinations;
    }


    @Override
    public HashSet<Integer[]> generateTuples(int n, int r) {
        return generateTuplesRecursively(n, r, 0, new Integer[r], new HashSet<>());
    }

    private HashSet<Integer[]> generateTuplesRecursively(int n, int r, int k, Integer[] tuple, HashSet<Integer[]> tuples){
        if (k == r){
            tuples.add(Arrays.copyOf(tuple, r));
        }
        else {
            for (int i = 1; i <= n; i++) {
                tuple[k] = i;
                generateTuplesRecursively(n, r, k+1, tuple, tuples);
            }
        }

        return tuples;
    }

    @Override
    public HashSet<Integer[]> generatePermutations(int n, int r) {
        return generatePermutationsRecursively(n, r, 0, new Integer[r], new boolean[n+1], new HashSet<>());
    }

    @Override
    public HashSet<Integer[]> generatePermutations(Integer[] nums) {
        return generatePermutationsRecursively(nums, 0, new HashSet<>());
    }

    private HashSet<Integer[]> generatePermutationsRecursively(Integer[] nums, int k, HashSet<Integer[]> permutations){
        if (k == nums.length){
            permutations.add(Arrays.copyOf(nums, nums.length));
        }
        else{
            for (int i = k; i < nums.length; i++) {
                swap(nums, k, i);
                generatePermutationsRecursively(nums, k+1, permutations);
                swap(nums, k, i);
            }
        }
        return permutations;
    }

    private HashSet<Integer[]> generatePermutationsRecursively(int n, int r, int k, Integer[] perm, boolean[] hasUsed, HashSet<Integer[]> permutations){
        if (k == r){
            permutations.add(Arrays.copyOf(perm, r));
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (!hasUsed[i])
                {
                    perm[k] = i;
                    hasUsed[i] = true;
                    generatePermutationsRecursively(n, r, k+1, perm, hasUsed, permutations);
                    hasUsed[i] = false;
                }
            }
        }
        return permutations;
    }

    @Override
    public List<Direction> solveMaze(int[][] maze) {
        return solveMazeRecursively(maze, 0, 0, 4, 4, new Tag(), new Stack<>());
    }

    private static class Tag{
        public boolean isFinished = false;
    }

    private Stack<Direction> solveMazeRecursively(int[][] maze, int x, int y, int goalX, int goalY, Tag tag, Stack<Direction> path){
        if (x >= 0 && y >= 0 && x < maze[0].length && y < maze.length
                && maze[y][x] == 0)
        {
            maze[y][x] = 1;  //this block has been passed

            if (x == goalX &&  y == goalY)
            {
                tag.isFinished = true;
                return path;
            }

            for (Direction dir : Direction.values()) {
                path.push(dir);
                solveMazeRecursively(maze, x + dir.dx, y + dir.dy, goalX, goalY, tag, path);
                if (tag.isFinished)
                    return path;

                path.pop();
            }

            maze[y][x] = 0;  //reset
        }
        return path;
    }
}
