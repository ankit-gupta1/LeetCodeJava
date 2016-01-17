import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        List<Integer> result = new ArrayList<>();

        for (int i = digits.length - 1; i >= 0; i--) {
            result.add(0, (digits[i] + carry) % 10);
            carry = (digits[i] + carry) / 10;
        }

        if (carry > 0) {
            result.add(0, carry);
        }

        int[] sol = new int[result.size()];
        int j = 0;
        for (Integer i : result) {
            sol[j++] = i;
        }

        return sol;
    }
}