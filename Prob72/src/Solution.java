public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dist = new int[m + 1][n + 1];

        for (int i = 0; i < n; i++) {
            dist[0][i + 1] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            dist[i + 1][0] = i + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dist[i][j] = dist[i - 1][j - 1];
                } else {
                    dist[i][j] = 1 + Math.min(dist[i - 1][j - 1], Math.min(dist[i - 1][j], dist[i][j - 1]));
                }
            }
        }

        return dist[m][n];
    }
}