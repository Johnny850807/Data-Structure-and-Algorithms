import dsa.algorithms.Sudoku;
import org.junit.Assert;
import org.junit.Test;

public class SudokuTest {

    int[][] answer = new int[][]{
            new int[]{5, 3, 4, 6, 7, 8, 9, 1, 2},
            new int[]{6, 7, 2, 1, 9, 5, 3, 4, 8},
            new int[]{1, 9, 8, 3, 4, 2, 5, 6, 7},
            new int[]{8, 5, 9, 7, 6, 1, 4, 2, 3},
            new int[]{4, 2, 6, 8, 5, 3, 7, 9, 1},
            new int[]{7, 1, 3, 9, 2, 4, 8, 5, 6},
            new int[]{9, 6, 1, 5, 3, 7, 2, 8, 4},
            new int[]{2, 8, 7, 4, 1, 9, 6, 3, 5},
            new int[]{3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    int[][] puzzle = new int[][]{
            new int[]{5, 3, 0, 0, 7, 0, 0, 0, 0},
            new int[]{6, 0, 0, 1, 9, 5, 0, 0, 0},
            new int[]{0, 9, 8, 0, 0, 0, 0, 6, 0},
            new int[]{8, 0, 0, 0, 6, 0, 0, 0, 3},
            new int[]{4, 0, 0, 8, 0, 3, 0, 0, 1},
            new int[]{7, 0, 0, 0, 2, 0, 0, 0, 6},
            new int[]{0, 6, 0, 0, 0, 0, 2, 8, 0},
            new int[]{0, 0, 0, 4, 1, 9, 0, 0, 5},
            new int[]{0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    @Test
    public void test(){
        Sudoku sudoku = new Sudoku() {
            @Override
            public int[][] solve(int[][] grids) {
                return answer;
            }
        };

        Assert.assertArrayEquals(answer, sudoku.solve(puzzle));
    }
}
