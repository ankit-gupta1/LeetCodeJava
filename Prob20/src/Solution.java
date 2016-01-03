import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        boolean result = true;
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        set.add('(');
        set.add('{');
        set.add('[');

        for (int i = 0; i < s.length() && result; i++) {
            Character c = s.charAt(i);
            if (set.contains(c)) {
                stack.push(c);
            } else {
                result = !stack.isEmpty() && stack.peek() == map.get(c);
                if (result) {
                    stack.pop();
                }
            }
        }

        return result && stack.isEmpty();
    }
}