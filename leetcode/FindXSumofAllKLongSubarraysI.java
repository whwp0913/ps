import java.util.*;

/**
 * https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/description/?envType=problem-list-v2&envId=sliding-window
 */
public class FindXSumofAllKLongSubarraysI {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        int i = 0;

        Map<Integer, Integer> countToNum = new HashMap<>();
        for (int end = 0; end < n; end++) {
            countToNum.compute(nums[end], (key, val) -> Objects.isNull(val) ? 1 : val + 1);

            if (i + k - 1 == end) {
                PriorityQueue<int[]> pq = new PriorityQueue<>(
                        Comparator.<int[]>comparingInt(a -> a[0]).reversed().thenComparingInt(a -> -a[1])
                );
                for (Map.Entry<Integer, Integer> e : countToNum.entrySet()) {
                    pq.offer(new int[] {e.getValue(), e.getKey()});
                }

                int count = 0;
                while (!pq.isEmpty() && count < x) {
                    int[] value = pq.poll();
                    answer[i] += value[0] * value[1];
                    count++;
                }
                countToNum.computeIfPresent(nums[i], (key, val) -> val - 1);
                i++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] result = new FindXSumofAllKLongSubarraysI().findXSum(
                new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2);
        System.out.println(Arrays.toString(result));
    }
}
