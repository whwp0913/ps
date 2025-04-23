import java.util.HashMap;

/**
 * https://leetcode.com/problems/count-largest-group/description/?envType=daily-question&envId=2025-04-23
 */
public class CountLargestGroup {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int maxCount = -1;
        for (int i = 1; i <= n; i++) {
            int num = sum(i);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            maxCount = Math.max(maxCount, countMap.get(num));
        }

        int answer = 0;
        for (int count : countMap.values()) {
            if (count == maxCount)
                answer++;
        }

        return answer;
    }

    private int sum(int num) {
        int total = 0;
        while (num > 0) {
            total += num % 10;
            num = num / 10;
        }

        return total;
    }
}
