import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int a = nums[i];
            int j = i + 1;
            int k = n - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                if (nums[j] + nums[k] + a == 0) {
                    List<Integer> triplet = new LinkedList<>();
                    triplet.add(a);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    res.add(triplet);
                    j++;
                    k--;
                } else if (nums[j] + nums[k] + a > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return res;
    }
}