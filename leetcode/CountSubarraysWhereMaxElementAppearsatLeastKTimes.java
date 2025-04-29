/**
 * https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2025-04-29
 */
public class CountSubarraysWhereMaxElementAppearsatLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE, total = 0;
        for (int num : nums) {
            if (max == num) {
                total++;
            } else if (num > max) {
                max = num;
                total = 1;
            }
        }
        if (total < k)
            return 0;

        int count = 0, n = nums.length;
        long answer = 0;

        for (int start = 0, end = 0; start < n; start++) {
            while (end < n && count < k) {
                if (nums[end] == max) {
                    count++;
                }
                end++;
            }
            if (count >= k) {
                answer += n - end + 1;
            }
            if (nums[start] == max)
                count--;
        }

        return answer;
    }

    public static void main(String[] args) {
        long result = new CountSubarraysWhereMaxElementAppearsatLeastKTimes().countSubarrays(
                new int[]{1, 3, 2, 3, 3}, 2
        );
        System.out.println(result);
    }
}
