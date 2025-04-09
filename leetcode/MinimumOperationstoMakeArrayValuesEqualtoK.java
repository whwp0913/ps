import java.util.*;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/?envType=daily-question&envId=2025-04-09
 */
public class MinimumOperationstoMakeArrayValuesEqualtoK {
    public int minOperations(int[] nums, int k) {
        if (nums.length < 2) {
            return nums[0] > k ? 1 : nums[0] == k ? 0 : -1;
        } else {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, size = 0;
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                if (!numSet.contains(num)) size++;
                numSet.add(num);
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            if (min < k) return -1;
            return min > k ? size : size - 1;
        }
    }

    public static void main(String[] args) {
        int result = new MinimumOperationstoMakeArrayValuesEqualtoK().minOperations(new int[]{5, 2, 5, 4, 5}, 2);
        System.out.println(result);
    }
}
