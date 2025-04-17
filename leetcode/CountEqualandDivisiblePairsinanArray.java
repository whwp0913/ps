/**
 * https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/description/?envType=daily-question&envId=2025-04-17
 */
public class CountEqualandDivisiblePairsinanArray {
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int[] counts = new int[101];
        for (int num : nums) {
            counts[num]++;
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (counts[nums[i]] < 2) continue;
            int pos = i + 1;
            while (pos < n) {
                if (nums[i] == nums[pos] && (i * pos) % k == 0) answer++;
                pos++;
            }
            counts[nums[i]]--;
        }

        return answer;
    }
}
