/**
 * https://leetcode.com/problems/count-symmetric-integers/description/?envType=daily-question&envId=2025-04-11
 */
public class CountSymmetricIntegers {
    public int countSymmetricIntegers(int low, int high) {
        int answer = 0;

        while (low <= high) {
            int length = (int)Math.log10(low) + 1;
            if (length % 2 == 0) {
                int n = length / 2, target = low, left = 0, right = 0;
                for (int i = 0; i < length; i++) {
                    int num = target % 10;
                    target /= 10;
                    if (i < n) {
                        right += num;
                    } else {
                        left += num;
                    }
                }
                if (left == right) {
                    answer++;
                }
            }
            low++;
        }

        return answer;
    }
}
