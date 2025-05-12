import java.util.*;

/**
 * https://leetcode.com/problems/finding-3-digit-even-numbers/description/?envType=daily-question&envId=2025-05-12
 */
public class Finding3DigitEvenNumbers {

    public int[] findEvenNumbers(int[] digits) {
        return combination(digits, new boolean[digits.length], new ArrayList<>(), new HashSet<>())
                .stream()
                .sorted()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private Set<Integer> combination(int[] digits, boolean[] visited, List<Integer> nums, Set<Integer> answer) {
        if (nums.size() == 3) {
            answer.add((nums.get(0) * 100) + (nums.get(1) * 10) + nums.get(2));
            return answer;
        }
        for (int i = 0; i < digits.length; i++) {
            if (visited[i]) continue;
            if (nums.size() == 0 && digits[i] == 0) continue;
            if (nums.size() == 2 && digits[i] % 2 != 0) continue;
            nums.add(digits[i]);
            visited[i] = true;
            combination(digits, visited, nums, answer);
            nums.remove(nums.size() - 1);
            visited[i] = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] result = new Finding3DigitEvenNumbers().findEvenNumbers(new int[]{2, 1, 3, 0});
        System.out.println(Arrays.toString(result));
    }
}
