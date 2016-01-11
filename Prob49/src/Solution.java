import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> histMap = new HashMap<>();
        Arrays.sort(strs);

        for (String str : strs) {
            List<String> temp = new ArrayList<>();
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String histogram = new String(chars);

            if (histMap.containsKey(histogram)) {
                temp = histMap.get(histogram);
            }

            temp.add(str);
            histMap.put(histogram, temp);
        }

        for (List<String> list : histMap.values()) {
            result.add(new ArrayList<>(list));
        }

        return result;
    }
}