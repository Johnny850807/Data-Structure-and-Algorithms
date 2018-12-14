package dsa.algorithms;

public interface Sudoku {
    /**
     * @param grids 9x9 grids of puzzle, 0 value entries are the places to solve
     * @return sovled 9x9 grids
     */
    int[][] solve(int[][] grids);
}
