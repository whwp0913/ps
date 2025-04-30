import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/?envType=problem-list-v2&envId=sliding-window
 */
public class MinimumDifferenceBetweenHighestandLowestofKScores {
    public int minimumDifference(int[] nums, int k) {
        if (k == 0)
            return 0;
        Arrays.sort(nums);

        int answer = Integer.MAX_VALUE, n = nums.length;
        for (int start = 0, end = 0; end < n; end++) {
            if (end - start + 1 == k) {
                answer = Math.min(answer, nums[end] - nums[start]);
                start += 1;
            }
        }

        return answer;
    }
}
