/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/?envType=daily-question&envId=2025-04-30
 */
public class FindNumberswithEvenNumberofDigits {
    public int findNumbers(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            int target = (int)Math.log10(num) + 1;
            if (target % 2 == 0)
                answer++;
        }
        return answer;
    }
}
