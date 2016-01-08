public class Solution {
    public String countAndSay(int n) {
        String result = new String();

        if (n > 0) {
            result += '1';

            for (int i = 2; i <= n; i++) {
                String temp = new String();
                int j = 1;
                int count = 1;
                char prev = result.charAt(0);

                while (j < result.length()) {
                    if (prev == result.charAt(j)) {
                        count++;
                    } else {
                        temp += String.valueOf(count) + prev;
                        count = 1;
                    }

                    prev = result.charAt(j);
                    j++;
                }

                temp += String.valueOf(count) + prev;
                result = temp;
            }
        }

        return result;
    }
}