import java.util.EnumMap;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/make-array-elements-equal-to-zero/description/?envType=problem-list-v2&envId=prefix-sum
 */
public class MakeArrayElementsEqualtoZero {
    public static void main(String[] args) {
        int result = new MakeArrayElementsEqualtoZero().countValidSelections(new int[]{1, 0, 2, 0, 3});
        System.out.println(result);
    }

    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int answer = 0;
        int[] zeros = IntStream.range(0, nums.length).filter(i -> nums[i] == 0).toArray();
        for (int zero : zeros) {
            int left = prefixSum[zero];
            int right = prefixSum[n] - left;
            if (left == right)
                answer += 2;
            else if (left + 1 == right || left == right + 1)
                answer += 1;
        }

        return answer;
    }
}
