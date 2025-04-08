/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/?envType=daily-question&envId=2025-04-08
 */
public class MinimumNumberofOperationstoMakeElementsinArrayDistinct {
    public int minimumOperations(int[] nums) {
        int[] counts = new int[101];
        int total = 0;
        for (int num : nums) {
            counts[num]++;
            if (counts[num] > 1)
                total++;
        }

        int answer = 0, idx = 0;
        while (total > 0) {
            answer++;
            for (int i = idx; i < idx + 3 && i < nums.length; i++) {
                if (counts[nums[i]] > 1) {
                    total--;
                }
                counts[nums[i]]--;
            }
            idx += 3;
        }

        return answer;
    }
}
