import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;

        if (m > 0) {
            int n = matrix[0].length;
            int k = Math.min(m, n);

            for (int i = 0; i < k / 2; i++) {
                for (int j = i; j < n - 1 - i; j++) {
                    result.add(matrix[i][j]);
                }

                for (int j = i; j < m - 1 - i; j++) {
                    result.add(matrix[j][n - 1 - i]);
                }

                for (int j = n - 1 - i; j > i; j--) {
                    result.add(matrix[m - 1 - i][j]);
                }

                for (int j = m - 1 - i; j > i ; j--) {
                    result.add(matrix[j][i]);
                }
            }

            if (k % 2 == 1) {
                if (m > n) {
                    for (int i = (k / 2); i < m - (k / 2); i++) {
                        result.add(matrix[i][k / 2]);
                    }
                } else {
                    for (int i = (k / 2); i < n - (k / 2); i++) {
                        result.add(matrix[k / 2][i]);
                    }
                }
            }
        }

        return result;
    }
}