public class Solution {
    public int mySqrt(int x) {
        int result = 0;

        if (x > 0) {
            int lo = 1;
            int hi = Integer.MAX_VALUE;

            while (true) {
                int mid = lo + (hi - lo) / 2;
                if (mid == x / mid) {
                    result = mid;
                    break;
                } else if (mid > x / mid) {
                    hi = mid - 1;
                } else if (mid + 1 > x /(mid + 1)) {
                    result = mid;
                    break;
                } else {
                    lo = mid + 1;
                }
            }
        }

        return result;
    }
}