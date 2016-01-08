public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] cols = new boolean[9][9];
        boolean[][][] box = new boolean[3][3][9];
        boolean isValid = true;

        for (int i = 0; i < 9 && isValid; i++) {
            boolean[] row = new boolean[9];

            for (int j = 0; j < 9 && isValid; j++) {
                int num = board[i][j] - '1';
                if (board[i][j] != '.') {
                    isValid = !row[num];

                    if (isValid) {
                        row[num] = true;
                        isValid = !cols[j][num];

                        if (isValid) {
                            cols[j][num] = true;
                            isValid = !box[i / 3][j / 3][num];

                            if (isValid) {
                                box[i / 3][j / 3][num] = true;
                            }
                        }
                    }
                }
            }
        }

        return isValid;
    }
}