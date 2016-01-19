import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        path = '/' + path;
        Stack<String> vars = new Stack<>();
        String result = new String();
        int i = 0;
        int j = 0;
        int n = path.length();

        while (j < n) {
            if (path.charAt(j) == '/') {
                if (j - i > 1) {
                    String subPath = path.substring(i + 1, j);
                    if (subPath.equals("..")) {
                        if (vars.size() > 0) {
                            vars.pop();
                        }
                    } else if (!subPath.equals(".")) {
                        vars.push(subPath);
                    }
                }

                i = j;
            }

            j++;
        }

        List<String> validPath = new ArrayList<>();
        while (!vars.isEmpty()) {
            validPath.add(0, vars.peek());
            vars.pop();
        }

        for (String str : validPath) {
            result += '/' + str;
        }

        return result.length() == 0 ? "/" : result;
    }
}