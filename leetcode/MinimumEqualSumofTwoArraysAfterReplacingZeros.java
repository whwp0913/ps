/**
 * https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/description/?envType=daily-question&envId=2025-05-10
 */
public class MinimumEqualSumofTwoArraysAfterReplacingZeros {
    public long minSum(int[] nums1, int[] nums2) {
        long num1Sum = 0, num2Sum = 0, num1ZeroCount = 0, num2ZeroCount = 0;

        for (long num : nums1) {
            num1Sum += num;
            if (num == 0) num1ZeroCount++;
        }
        for (long num : nums2) {
            num2Sum += num;
            if (num == 0) num2ZeroCount++;
        }

        long num1Min = num1Sum + num1ZeroCount;
        long num2Min = num2Sum + num2ZeroCount;

        if (num1ZeroCount == 0 && num2ZeroCount == 0)
            return num1Sum == num2Sum ? num1Sum : -1;
        else if (num1ZeroCount == 0)
            return num2Min <= num1Sum ? num1Sum : -1;
        else if (num2ZeroCount == 0)
            return num1Min <= num2Sum ? num2Sum : -1;
        else
            return Math.max(num1Min, num2Min);
    }
}
