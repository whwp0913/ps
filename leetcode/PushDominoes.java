/**
 * https://leetcode.com/problems/push-dominoes/?envType=daily-question&envId=2025-05-02
 */
public class PushDominoes {
    public static void main(String[] args) {
        new PushDominoes().pushDominoes(".L.R...LR..L..");
    }
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] forces = new int[n];

        int force = 0;
        for (int i = 0; i < n; i++) {
            char c = dominoes.charAt(i);
            if (c == 'R')
                force = n;
            else if (c == 'L')
                force = 0;
            else
                force = Math.max(force - 1, 0);
            forces[i] += force;
        }

        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = dominoes.charAt(i);
            if (c == 'L')
                force = n;
            else if (c == 'R')
                force = 0;
            else
                force = Math.max(force - 1, 0);
            forces[i] -= force;
        }

        StringBuilder answer = new StringBuilder();
        for (int f : forces) {
            if (f > 0) answer.append("R");
            else if (f < 0) answer.append("L");
            else answer.append(".");
        }

        return answer.toString();
    }
}
