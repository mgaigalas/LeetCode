/**
 * Solution class contains solution for LeetCode problem:
 * #36. Valid Sudoku.
 *
 * @author Marius Gaigalas on 26/09/2024
 */
public class Solution {
    /**
     * Determines if a 9 x 9 Sudoku board is valid.
     * Only the filled cells need to be validated according to the following rules:
     * <ul>
     *     <li>Each row must contain the digits 1-9 without repetition.</li>
     *     <li>Each column must contain the digits 1-9 without repetition.</li>
     *     <li>Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.</li>
     * </ul>
     * <p>
     * Note: A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     *
     * @param board 2D array of characters, where numbers are values and '.' are empty spaces
     * @return flag indicating if board is valid
     */
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int[][] rows = new int[n][n];
        int[][] cols = new int[n][n];
        int[][] boxes = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int pos = board[r][c] - '1';

                // rows
                if (rows[r][pos] > 0) {
                    return false;
                }
                rows[r][pos] = 1;

                // cols
                if (cols[c][pos] > 0) {
                    return false;
                }
                cols[c][pos] = 1;

                // boxes
                int box = (r / 3) * 3 + (c / 3);
                if (boxes[box][pos] > 0) {
                    return false;
                }
                boxes[box][pos] = 1;
            }
        }
        return true;
    }
}