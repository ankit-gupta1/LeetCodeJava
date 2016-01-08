import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int longest = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.empty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }

        if (stack.empty()) {
            longest = s.length();
        } else {
            longest = 0;
            int last = s.length();

            while (!stack.empty()) {
                int curr = stack.peek();
                longest = Math.max(last - curr - 1, longest);
                last = curr;

                if (curr == stack.size() - 1) {
                    last = 0;
                    break;
                }
                stack.pop();
            }

            longest = Math.max(longest, last);
        }

        return longest;
    }
}