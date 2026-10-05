class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char val = '1'; val <= '9'; val++) {
                        if (canPlace(board, r, c, val)) {
                            board[r][c] = val;

                            if (solve(board)) {
                                return true;
                            }

                            board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean canPlace(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check row constraint
            if (board[row][i] == num) return false;

            // Check column constraint
            if (board[i][col] == num) return false;

            // Check 3x3 sub-grid constraint
            int startRow = 3 * (row / 3);
            int startCol = 3 * (col / 3);
            if (board[startRow + i / 3][startCol + i % 3] == num) return false;
        }
        return true;
    }
}