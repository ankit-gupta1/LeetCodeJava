import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private int currLen;
    private int width;

    public String centerJustified(String[] words, int start, int end) {
        String result = new String();
        int spaces = width - (currLen - (end - start));
        int[] gaps = new int[end - start + 1];
        int minFill = spaces / (end - start);
        int remaining = spaces % (end - start);

        Arrays.fill(gaps, minFill);
        gaps[0] = 0;
        int i = 1;
        while (remaining > 0) {
            gaps[i++]++;
            remaining--;
        }

        i = start;
        int count = 0;
        while (i <= end) {
            char[] spaceGaps = new char[gaps[count++]];
            Arrays.fill(spaceGaps, ' ');
            result += String.valueOf(spaceGaps) + words[i++];
        }

        return result;
    }

    public String leftJustified(String[] words, int start, int end) {
        String result = new String();
        int[] gaps = new int[end - start + 1];
        Arrays.fill(gaps, 1);
        gaps[end - start] = width - currLen;

        int i = start;
        int count = 0;
        while (i <= end) {
            char[] spaceGaps = new char[gaps[count++]];
            Arrays.fill(spaceGaps, ' ');
            result += words[i++] + String.valueOf(spaceGaps);
        }

        return result;
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        width = maxWidth;

        while (i < words.length) {
            currLen = -1;
            int j = i;
            while (j < words.length && (currLen + 1 + words[j].length()) <= maxWidth) {
                currLen += words[j].length() + 1;
                j++;
            }

            if (j == i + 1 || j == words.length) {
                result.add(leftJustified(words, i, j - 1));
            } else {
                result.add(centerJustified(words, i, j - 1));
            }

            i = j;
        }

        return result;
    }
}