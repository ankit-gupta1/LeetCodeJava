public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = new String();
        boolean keepLooping = strs.length > 0;
        int i = 0;

        while (keepLooping) {
            if (i < strs[0].length()) {
                char prev = strs[0].charAt(i);
                for (int j = 1; j < strs.length && keepLooping; j++) {
                    keepLooping = i < strs[j].length() && prev == strs[j].charAt(i);
                }

                if (!keepLooping) {
                    break;
                }

                prefix += prev;
            } else {
                break;
            }

            i++;
        }

        return prefix;
    }
}