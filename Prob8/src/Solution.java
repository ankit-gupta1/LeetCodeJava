public class Solution {
    public int myAtoi(String str) {
        long res = 0;
        int i = 0;
        int n = str.length();
        Boolean foundSign = false;
        int sign = 1;

        while (i < n) {
            Character c = str.charAt(i);
            if (!foundSign && c == ' ') {
                i++;
                continue;
            } else if (!(c >= '0' && c <= '9') && foundSign) {
                break;
            } else if ((c == '+' || c == '-') && !foundSign) {
                foundSign = true;
                sign = (c == '+' ? 1 : -1);
                i++;
                continue;
            }

            if (c >= '0' && c <= '9') {
                foundSign = true;
                res = res * 10;
                res = res + (c - '0');
                i++;

                if (res > Integer.MAX_VALUE) {
                    if (sign == 1) {
                        res = Integer.MAX_VALUE;
                    } else {
                        res = Integer.MIN_VALUE;
                    }
                    break;
                }
            } else {
                break;
            }
        }

        if (res != Integer.MIN_VALUE) {
            res = res * sign;
        }

        return (int)res;
    }
}