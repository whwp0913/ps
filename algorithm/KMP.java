import java.util.ArrayList;
import java.util.List;

public class KMP {
    public static void main(String[] args) {
        int[] PI = makePiTable("aabaaef");
        String word = "aabaaef";
        String pattern = "aa";
        List<Integer> indexList = KMP(word, pattern);
        System.out.println(indexList);
    }

    private static int[] makePiTable(String pattern) {
        int n = pattern.length();
        int[] pi = new int[n];

        int j = 0; // 현재까지 일치한 접두/접미사의 길이

        for (int i = 1; i < n; i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }

    private static List<Integer> KMP(String word, String pattern) {
        List<Integer> result = new ArrayList<>();
        int[] pi = makePiTable(pattern);
        int j = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            while (j > 0 && word.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (word.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    j = pi[j];
                    result.add(i - pattern.length() + 1);
                } else {
                    j++;
                }
            }
        }

        return result;
    }
}
