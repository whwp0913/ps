/**
 * https://leetcode.com/problems/count-and-say/description/?envType=daily-question&envId=2025-04-18
 */
public class CountandSay {
    public static void main(String[] args) {
        String result = new CountandSay().countAndSay(4);
        System.out.println(result);
    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String before = countAndSay(n - 1);
        StringBuilder answer = new StringBuilder();
        char current = before.charAt(0);
        int count = 0;

        for (int i = 0; i < before.length(); i++) {
            if (current == before.charAt(i)) {
                count++;
            } else {
                answer.append(count).append(current);
                current = before.charAt(i);
                count = 1;
            }
        }
        if (count > 0)
            answer.append(count).append(current);

        return answer.toString();
    }
}
