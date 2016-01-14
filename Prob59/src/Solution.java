public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int x = 1;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                matrix[i][j] = x++;
            }

            for (int j = i; j < n - 1 - i; j++) {
                matrix[j][n - 1 - i] = x++;
            }

            for (int j = n - 1 - i; j > i; j--) {
                matrix[n - 1 - i][j] = x++;
            }

            for (int j = n - 1 - i; j > i; j--) {
                matrix[j][i] = x++;
            }
        }

        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = x++;
        }

        return matrix;
    }
}