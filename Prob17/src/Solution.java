import java.util.*;

public class Solution {
    private int len;

    public void letterComboBT(List<String> result, String digits, String curr,
                              HashMap<Character, ArrayList<Character>> letters, int pos) {
        if (curr.length() == len) {
            result.add(curr);
        } else {
            for (int i = pos; i < len; i++) {
                for (Character c : letters.get(digits.charAt(i))) {
                    curr += c;
                    letterComboBT(result, digits, curr, letters, i + 1);
                    curr = curr.substring(0, curr.length() - 1);
                }
            }
        }
    }

    public void letterComboIter(List<String> result, String digits,
                                HashMap<Character, ArrayList<Character>> letters) {
        for (Character i : digits.toCharArray()) {
            List<String> current = new LinkedList<>();
            for (Character j : letters.get(i)) {
                if (result.size() == 0) {
                    current.add("" + j);
                } else {
                    for (String s : result) {
                        current.add(s + j);
                    }
                }
            }

            result = current;
        }

        Collections.sort(result);
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character, ArrayList<Character>> letters = new HashMap<>();
        List<String> result = new LinkedList<>();
        if (digits.length() == 0) {
            return result;
        }

        letters.put('1', new ArrayList<>());
        letters.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        letters.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        letters.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        letters.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        letters.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        letters.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        letters.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        letters.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        letters.put('*', new ArrayList<>());
        letters.put('0', new ArrayList<>());
        letters.put('#', new ArrayList<>());

        len = digits.length();
        letterComboBT(result, digits, "", letters, 0);
        return result;
    }
}