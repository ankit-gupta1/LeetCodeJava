import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public void permutation(List<List<Integer>> result, List<Integer> nums, int pos) {
        if (pos == nums.size()) {
            result.add(new ArrayList<>(nums));
        } else {
            int temp;
            for (int i = pos; i < nums.size(); i++) {
                temp = nums.get(i);
                nums.set(i, nums.get(pos));
                nums.set(pos, temp);
                permutation(result, nums, pos + 1);
                temp = nums.get(i);
                nums.set(i, nums.get(pos));
                nums.set(pos, temp);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        permutation(result, curr, 0);
        return result;
    }
}