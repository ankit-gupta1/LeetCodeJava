public class Solution {
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][][] tiles = new boolean[3][3][9];

    public boolean solve(char[][] board, int p) {
        if (p == 81) {
            return true;
        } else {
            boolean truth = false;
            int i = p / 9;
            int j = p % 9;

            if (board[i][j] == '.') {
                for (int k = 0; k < 9 && !truth; k++) {
                    if (!rows[i][k] && !cols[j][k] && !tiles[i / 3][j / 3][k]) {
                        rows[i][k] = true;
                        cols[j][k] = true;
                        tiles[i / 3][j / 3][k] = true;
                        board[i][j] = (char) (k + '1');
                        truth = solve(board, p + 1);

                        if (!truth) {
                            rows[i][k] = false;
                            cols[j][k] = false;
                            tiles[i / 3][j / 3][k] = false;
                            board[i][j] = '.';
                        }
                    }
                }
            } else {
                truth = solve(board, p + 1);
            }

            return truth;
        }
    }

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    tiles[i / 3][j / 3][num] = true;
                }
            }
        }

        boolean sol = solve(board, 0);
    }
}