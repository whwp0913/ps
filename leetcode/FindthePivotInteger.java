/**
 * https://leetcode.com/problems/find-the-pivot-integer/description/?envType=problem-list-v2&envId=prefix-sum
 */
public class FindthePivotInteger {
    public int pivotInteger(int n) {
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (i + 1);
        }
        for (int i = 1; i < prefixSum.length; i++) {
            if (prefixSum[i] == prefixSum[n] - prefixSum[i - 1])
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int answer = new FindthePivotInteger().pivotInteger(4);
        System.out.println(answer);
    }
}
