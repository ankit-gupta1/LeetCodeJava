public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] product = new int[n1 + n2 + 1];

        for (int i = n2 - 1; i >= 0 ; i--) {
            for (int j = n1 - 1; j >= 0 ; j--) {
                product[i + j + 1] += (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
            }
        }

        int carry = 0;
        for (int i = n1 + n2; i >= 0 ; i--) {
            int sum = product[i] + carry;
            carry = sum / 10;
            product[i] = sum % 10;
        }

        StringBuilder result = new StringBuilder();
        for(Integer i : product) {
            result.append(i);
        }

        while (result.length() > 0 && result.charAt(0) == 0) {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}