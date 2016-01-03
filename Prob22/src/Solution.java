import java.util.LinkedList;
import java.util.List;

public class Solution {
    int len;

    public void genParBT(List<String> result, char[] curr, int left, int right) {
        if (left == len && right == len) {
            result.add(String.valueOf(curr));
        } else if (left <= len) {
            curr[left + right] = '(';
            genParBT(result, curr, left + 1, right);

            if (right < left) {
                curr[left + right] = ')';
                genParBT(result, curr, left, right + 1);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        len = n;
        genParBT(result, new char[2 * n], 0, 0);
        return result;
    }
}