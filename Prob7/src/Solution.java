public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;

        Boolean sign = x >= 0;
        int digs = 0;
        int temp = Math.abs(x);
        long result = 0;

        do {
            digs++;
            temp = temp / 10;
        } while (temp > 0);

        int count = 0;
        temp = Math.abs(x);
        while (digs > 0) {
            result += (temp / (long)Math.pow(10, digs - 1)) * (long)Math.pow(10, count);
            temp = temp % (int)Math.pow(10, digs - 1);
            digs--;
            count++;
            if (result > Integer.MAX_VALUE) {
                result = 0;
                break;
            }
        }

        if (!sign) result = -result;
        return (int)result;
    }
}