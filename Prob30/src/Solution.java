import java.util.*;

public class Solution {
    public void createMap(HashSet<String> stringHashSet, String[] words, int pos) {
        if (words.length == pos) {
            stringHashSet.add(String.join("", words));
        } else {
            String temp = new String();
            for (int i = pos; i < words.length; i++) {
                temp = words[pos];
                words[pos] = words[i];
                words[i] = temp;
                createMap(stringHashSet, words, pos + 1);
                temp = words[pos];
                words[pos] = words[i];
                words[i] = temp;
            }
        }
    }

    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> result = new LinkedList<>();

        if (words.length > 0) {
            int size = words[0].length();
            int n = words.length;

            if (s.length() >= size * n) {
                HashSet<String> set = new HashSet<>();
                createMap(set, words, 0);
                int len = size * n;

                for(String str : set) {
                    System.out.println(str);
                }

                for (int i = 0; i < s.length() - len + 1; i++) {
                    if (set.contains(s.substring(i, i + len))) {
                        result.add(i);
                    }
                }
            }
        }

        return result;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        if (m > 0) {
            int n = words.length;

            if (n > 0) {
                int size = words[0].length();
                int len = n * size;

                if (m >= len) {
                    Map<String, Integer> wordCount = new HashMap<>();

                    for (String str : words) {
                        wordCount.put(str, wordCount.getOrDefault(str, 0) + 1);
                    }

                    for (int i = 0; i < m - len + 1; i++) {
                        Map<String, Integer> wordHash = new HashMap<>();

                        for (int j = i; j < i + len; j = j + size) {
                            String str = s.substring(j, j + size);
                            if (!wordCount.containsKey(str)) {
                                break;
                            }

                            wordHash.put(str, wordHash.getOrDefault(str, 0) + 1);
                            if (wordHash.get(str) > wordCount.get(str)) {
                                break;
                            }
                        }

                        if (wordHash.equals(wordCount)) {
                            result.add(i);
                        }
                    }
                }
            }
        }

        return result;
    }
}