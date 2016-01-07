public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        int sign = (dividend >= 0) ^ (divisor > 0) ? -1 : 1;

        long quotient = 0;
        long num = dividend;
        long den = divisor;
        num = Math.abs(num);
        den = Math.abs(den);

        while (num >= den) {
            long d = den;
            long q = 1;

            while ((d << 1) < num) {
                d = d << 1;
                q = q << 1;
            }

            quotient += q;
            num -= d;
        }

        if (quotient > Integer.MAX_VALUE && sign == 1) {
            quotient = Integer.MAX_VALUE;
        }

        return (int)(quotient * sign);
    }
}