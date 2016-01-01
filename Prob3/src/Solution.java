import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charLoc = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        int end = 0;
        int strLen = s.length();

        while (end < strLen) {
            char c = s.charAt(end);
            maxLen = Math.max(maxLen, charLoc.size());

            if (!charLoc.containsKey(c)) {
                charLoc.put(c, end);
            } else {
                int begin = charLoc.get(c);
                for (int i = start; i <= begin; i++) {
                    charLoc.remove(s.charAt(i));
                }

                start = begin + 1;
                charLoc.put(c, end);
            }

            end++;
        }

        maxLen = Math.max(maxLen, charLoc.size());
        return maxLen;
    }
}