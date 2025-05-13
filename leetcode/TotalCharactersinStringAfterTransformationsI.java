/**
 * https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/?envType=daily-question&envId=2025-05-13
 */
public class TotalCharactersinStringAfterTransformationsI {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;

        int[][] dp = new int[26][t + 1];
        for (int c = 0; c < 26; c++) {
            dp[c][0] = 1;
        }
        for (int i = 1; i <= t; i++) {
            for (int c = 0; c < 26; c++) {
                if (c == 25) {
                    dp[c][i] = (dp[0][i - 1] + dp[1][i - 1]) % MOD;
                } else {
                    dp[c][i] = dp[c + 1][i - 1];
                }
            }
        }

        int answer = 0;
        for (char c : s.toCharArray()) {
            answer = (answer + dp[c - 'a'][t]) % MOD;
        }

        return answer;
    }
}
