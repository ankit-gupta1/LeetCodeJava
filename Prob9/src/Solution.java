public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int digs = 0;
        int temp = Math.abs(x);
        do {
            digs++;
            temp = temp / 10;
        } while (temp > 0);

        int i = 0;
        int j = digs - 1;
        boolean result = true;
        temp = Math.abs(x);
        int z = Math.abs(x);

        while (i < j && result) {
            int u = temp / (int)Math.pow(10, j);
            temp = temp % (int)Math.pow(10, j);
            int y = z % 10;
            z = z / 10;
            result = u == y;
            i++;
            j--;
        }

        return result;
    }
}