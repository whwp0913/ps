/**
 * https://leetcode.com/problems/three-consecutive-odds/description/?envType=daily-question&envId=2025-05-11
 */
public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int oddCount = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                oddCount = 0;
            } else {
                oddCount += 1;
                if (oddCount >= 3) 
                    return true;
            }
        }

        return false;
    }
}
