public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int j = b.length() - 1;
        int i = a.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? (a.charAt(i) - '0') : 0;
            int y = j >= 0 ? (b.charAt(j) - '0') : 0;
            int sum = x + y + carry;
            result.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }

        if (carry == 1) {
            result.append(carry);
        }

        result.reverse();
        return result.toString();
    }
}