import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] elements = new int[2];
        HashMap<Integer, ArrayList<Integer>> numIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numIdx.get(nums[i]) == null) numIdx.put(nums[i], new ArrayList<>());
            numIdx.get(nums[i]).add(i);
        }

        for (HashMap.Entry<Integer, ArrayList<Integer>> iterator :
                numIdx.entrySet()) {
            Integer first = iterator.getKey();
            Integer second = target - first;

            if (Objects.equals(second, first) && iterator.getValue().size() > 1) {
                elements[0] = iterator.getValue().get(0) + 1;
                elements[1] = iterator.getValue().get(1) + 1;
                break;
            } else if (numIdx.containsKey(second) && !Objects.equals(second, first)) {
                elements[0] = numIdx.get(first).get(0) + 1;
                elements[1] = numIdx.get(second).get(0) + 1;
                Arrays.sort(elements);
                break;
            }
        }

        return elements;
    }
}

class Prob1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {2, 7, 11, 15};
        int[] pair = sol.twoSum(numbers, 9);
        System.out.println(pair[0]);
        System.out.println(pair[1]);
    }
}