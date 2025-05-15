import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/description/?envType=daily-question&envId=2025-05-15
 */
public class LongestUnequalAdjacentGroupsSubsequenceI {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> answer = new ArrayList<>();
        int group = -1;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (groups[i] != group) {
                group = groups[i];
                answer.add(words[i]);
            }
        }

        return answer;
    }
}
