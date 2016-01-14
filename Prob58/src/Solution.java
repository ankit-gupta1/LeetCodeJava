public class Solution {
    public int lengthOfLastWord(String s) {
        int last = 0;
        int curr = 0;
        for (Character c : s.toCharArray()) {
            if (c != ' ') {
                curr++;
            } else {
                if (curr > 0) {
                    last = curr;
                }

                curr = 0;
            }
        }

        if (curr > 0) {
            last = curr;
        }

        return last;
    }
}