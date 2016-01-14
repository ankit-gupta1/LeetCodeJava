public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int paths = 0;
        int m = obstacleGrid.length;

        if (m > 0) {
            int n = obstacleGrid[0].length;

            if (n > 0) {
                int[][] dp = new int[m][n];

                for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
                    dp[0][i] = 1;
                }

                for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
                    dp[i][0] = 1;
                }

                boolean proceed = true;
                for (int i = 1; i < m && proceed; i++) {
                    for (int j = 1; j < n && proceed; j++) {
                        if (obstacleGrid[i][j] != 1) {
                            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                        }

                        proceed = dp[i][j] > 0;
                    }
                }

                paths = dp[m - 1][n - 1];
            }
        }

        return paths;
    }
}