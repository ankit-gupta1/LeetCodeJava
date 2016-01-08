import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public void solve(List<List<Integer>> result, List<Integer> curr, int[] nums, int sum, int target, int pos) {
        if (sum == target) {
            result.add(new ArrayList<>(curr));
        } else if (sum < target) {
            for (int i = pos; i < nums.length; i++) {
                if (target - sum < nums[i]) {
                    continue;
                }

                sum += nums[i];
                curr.add(nums[i]);
                solve(result, curr, nums, sum, target, i);
                sum -= nums[i];
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        solve(result, new ArrayList<>(), candidates, 0, target, 0);
        return result;
    }
}