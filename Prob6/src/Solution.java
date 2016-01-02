public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String zigZagStr = new String();
        int[] evenStep = new int[numRows];
        int[] oddStep = new int[numRows];
        int n = s.length();

        for (int i = 0; i < numRows; i++) {
            evenStep[i] = 2 * (numRows - 1 - i);
            oddStep[i] = (2 * i);
        }

        oddStep[numRows - 1] = 0;
        evenStep[numRows - 1] = 2 * (numRows - 1);

        for (int i = 0; i < numRows; i++) {
            Boolean even = true;
            int j = i;
            int prev = -1;

            while (j < n) {
                if (j != prev) zigZagStr += s.charAt(j);
                prev = j;
                j = j + (even ? evenStep[i] : oddStep[i]);
                even = !even;
            }
        }

        return zigZagStr;
    }
}