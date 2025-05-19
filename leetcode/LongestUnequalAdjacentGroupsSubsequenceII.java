import java.util.*;

/**
 * https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/?envType=daily-question&envId=2025-05-16
 */
public class LongestUnequalAdjacentGroupsSubsequenceII {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
            for (int j = i + 1; j < n; j++) {
                if (groups[i] == groups[j]) continue;
                if (!isHammingDistance(words[i], words[j])) continue;
                graph.get(i).add(j);
            }
        }
        List<Integer> longest = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> path = dfs(i, graph);
            if (path.size() > longest.size()) {
                longest = path;
            }
        }

        List<String> answer = new ArrayList<>();
        for (int idx : longest) {
            answer.add(words[idx]);
        }

        return answer;
    }

    private boolean isHammingDistance(String word, String other) {
        if (word.length() != other.length())
            return false;

        int diff = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) != other.charAt(i)) {
                diff++;
                if (diff > 1)
                    return false;
            }
        }

        return diff == 1;
    }

    private Map<Integer, List<Integer>> dp = new HashMap<>();

    private List<Integer> dfs(int node, Map<Integer, List<Integer>> graph) {
        if (dp.containsKey(node))
            return dp.get(node);

        List<Integer> main = new ArrayList<>();
        for (int edge : graph.getOrDefault(node, Collections.emptyList())) {
            List<Integer> sub = dfs(edge, graph);
            if (sub.size() > main.size())
                main = sub;
        }
        List<Integer> result = new ArrayList<>();
        result.add(node);
        result.addAll(main);
        dp.put(node, result);

        return result;
    }
}
