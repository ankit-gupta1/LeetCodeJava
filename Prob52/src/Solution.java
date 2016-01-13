import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private int result;
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

    public void nQueens(List<String> curr, int row) {
        if (row == curr.size()) {
            result++;
        } else {
            for (int i = 0; i < curr.size(); i++) {
                if (isValid(curr, row, i)) {
                    curr.set(row, replaceCharAt(curr.get(row), i, 'Q'));
                    nQueens(curr, row + 1);
                    curr.set(row, replaceCharAt(curr.get(row), i, '.'));
                }
            }
        }
    }

    public int totalNQueens(int n) {
        result = 0;
        List<String> curr = new ArrayList<>(Collections.nCopies(n, new String(new char[n]).replace('\0', '.')));
        nQueens(curr, 0);
        return result;
    }
}