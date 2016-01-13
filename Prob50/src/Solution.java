public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double result = myPow(x, n / 2);

        if (n % 2 == 0) {
            result = result * result;
        } else {
            if (n > 0) {
                result = result * result * x;
            } else {
                result = result * result / x;
            }
        }

        return result;
    }
}