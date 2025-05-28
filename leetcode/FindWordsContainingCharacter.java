import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-words-containing-character/description/?envType=daily-question&envId=2025-05-24
 */
public class FindWordsContainingCharacter {
    public List<Integer> findWordsContaining(String[] words, char x) {
        var answer = new ArrayList<Integer>();
        int idx = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (c == x) {
                    answer.add(idx);
                    break;
                }
            }
            idx++;
        }
        return answer;
    }
}
