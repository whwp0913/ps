import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountCompleteSubarraysinanArray {
    public int countCompleteSubarrays(int[] nums) {
        long totalDistinct = Arrays.stream(nums).distinct().count();

        Map<Integer, Integer> m = new HashMap<>();
        int n = nums.length, start = 0, answer = 0;
        for (int end = 0; end < n; end++) {
            m.put(nums[end], m.getOrDefault(nums[end], 0) + 1);
            while (totalDistinct == m.size()) {
                answer += n - end;
                m.put(nums[start], m.get(nums[start]) - 1);
                if (m.get(nums[start]) == 0)
                    m.remove(nums[start]);
                start += 1;
            }
        }

        return answer;
    }
}
