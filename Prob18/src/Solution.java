import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            int a = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                int b = nums[j];
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int p = j + 1;
                int q = n - 1;
                while (p < q) {
                    if (p > j + 1 && nums[p] == nums[p - 1]) {
                        p++;
                        continue;
                    }

                    int sum = a + b + nums[p] + nums[q];
                    if (sum == target) {
                        List<Integer> quartet = new LinkedList<>();
                        quartet.add(a);
                        quartet.add(b);
                        quartet.add(nums[p]);
                        quartet.add(nums[q]);
                        result.add(quartet);
                        p++;
                        q--;
                    } else if (sum > target) {
                        q--;
                    } else {
                        p++;
                    }
                }
            }
        }

        return result;
    }
}