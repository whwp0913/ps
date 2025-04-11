/**
 * https://leetcode.com/problems/maximum-repeating-substring/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class MaximumRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        while (true) {
            sb.append(word);
            if (sequence.contains(sb)) {
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}
