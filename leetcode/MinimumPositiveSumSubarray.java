import java.util.List;

/**
 * https://leetcode.com/problems/minimum-positive-sum-subarray/?envType=problem-list-v2&envId=prefix-sum
 */
public class MinimumPositiveSumSubarray {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums.get(i);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = l; i <= n; i++) {
            int left = l;
            while (left <= r) {
                if (i - left >= 0) {
                    int target = prefixSum[i] - prefixSum[i - left];
                    if (target > 0)
                        answer = Math.min(answer, target);
                }
                left++;
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
