import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/description/?envType=daily-question&envId=2025-04-07
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 > 0)
            return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
