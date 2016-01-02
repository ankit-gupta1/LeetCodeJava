public class Solution {
    private int len;
    private int maxStart;
    private int maxEnd;

    public void isPalindrome(String s, int i, int j) {
        for (int m = i, n = j; m >= 0 && n < len && (s.charAt(m) == s.charAt(n)); m--, n++) {
            if (n - m > maxEnd - maxStart) {
                maxStart = m;
                maxEnd = n;
            }
        }
    }

    public String longestPalindrome(String s) {
        len = s.length();
        maxStart = 0;
        maxEnd = 0;

        for (int i = 0; i < len; i++) {
            isPalindrome(s, i, i);
            isPalindrome(s, i, i + 1);
        }

        return s.substring(maxStart, maxEnd);
    }
}