import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-middle-index-in-array/description/?envType=problem-list-v2&envId=prefix-sum
 */
public class FindtheMiddleIndexinArray {
    public int findMiddleIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int left = 0, n = nums.length;
        int answer = -1;
        for (int i = 0; i < n; i++) {
            total -= nums[i];
            if (left == total)
                return i;
            left += nums[i];
        }

        return answer;
    }
}
