/**
 * https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/?envType=daily-question&envId=2025-04-28
 */
public class CountSubarraysWithScoreLessThanK {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        long answer = 0;
        for (int start = 0; start < n; start++) {
            int l = start + 1, r = n;
            int valid = start;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                long sum = prefixSum[mid] - prefixSum[start];
                long len = mid - start;
                if (sum * len < k) {
                    valid = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            answer += valid - start;
        }

        return answer;
    }
}
