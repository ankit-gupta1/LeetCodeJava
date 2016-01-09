public class Solution {
    public boolean isMatch(String s, String p) {
        boolean result = true;
        int m = s.length();
        int n = p.length();
        int i = 0;
        int j = 0;
        int l = -1;
        int k = -1;

        while (i < m && result) {
            if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < n && p.charAt(j) == '*') {
                l = i;
                k = j;
                j++;
            } else if (k != -1) {
                l++;
                i = l;
                j = k + 1;
            } else {
                result = false;
            }
        }

        while (result && j < n) {
            result = p.charAt(j++) == '*';
        }

        return result;
    }
}