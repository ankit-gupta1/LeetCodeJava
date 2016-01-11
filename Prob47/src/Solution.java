import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public boolean noswap(int k, int i, int[] nums) {
        for (int j = k; j < i; j++) {
            if (nums[j] == nums[i]) {
                return true;
            }
        }
        return false;
    }
    public void permute(List<List<Integer>> result, int[] nums, int pos) {
        if (pos == nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            int temp;
            for (int i = pos; i < nums.length; i++) {
                if (noswap(pos, i, nums)) {
                    continue;
                }

                temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
                permute(result, nums, pos + 1);
                temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, nums, 0);
        return result;
    }
}