import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public boolean isValid(List<String> curr, int row, int col) {
        boolean truth = true;

        for (int i = 0; i < row && truth; i++) {
            truth = curr.get(i).charAt(col) == '.';
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 && truth; i--, j--) {
            truth = curr.get(i).charAt(j) == '.';
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < curr.size() && truth; i--, j++) {
            truth = curr.get(i).charAt(j) == '.';
        }

        return truth;
    }

    public static String replaceCharAt(String s, int pos, char c) {
        return s.substring(0,pos) + c + s.substring(pos+1);
    }

    public void nQueens(List<List<String>> result, List<String> curr, int row) {
        if (row == curr.size()) {
            result.add(new ArrayList<>(curr));
        } else {
            for (int i = 0; i < curr.size(); i++) {
                if (isValid(curr, row, i)) {
                    curr.set(row, replaceCharAt(curr.get(row), i, 'Q'));
                    nQueens(result, curr, row + 1);
                    curr.set(row, replaceCharAt(curr.get(row), i, '.'));
                }
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>(Collections.nCopies(n, new String(new char[n]).replace('\0', '.')));
        nQueens(result, curr, 0);
        return result;
    }
}