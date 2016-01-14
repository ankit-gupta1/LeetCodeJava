import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        k = k % factorial[n];
        for (int i = n; i > 0 ; i--) {
            int pos = k / factorial[i - 1];
            k = k % factorial[i - 1];
            result.append(nums.get(pos));
            nums.remove(pos);
        }

        return result.toString();
    }
}