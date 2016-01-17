public class Solution {
    public int climbStairs(int n) {
        int f_2 = 1;
        int f_1 = 2;
        int f_0 = 0;

        for (int i = 3; i <= n ; i++) {
            f_0 = f_1 + f_2;
            f_2 = f_1;
            f_1 = f_0;
        }

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return f_2;
        } else if (n == 2) {
            return f_1;
        } else {
            return f_0;
        }
    }
}