import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinimumTimetoReachLastRoomI {

    int[][] dir = {{0, 1},{1, 0},{0, -1},{-1, 0}};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] minTimes = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minTimes[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        pq.offer(new int[] {0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], t = curr[2];
            for (int[] d : dir) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                int waitTime = Math.max(t, moveTime[nx][ny]) + 1;
                if (waitTime < minTimes[nx][ny]) {
                    minTimes[nx][ny] = waitTime;
                    pq.offer(new int[] {nx, ny, waitTime});
                }
            }
        }
        
        return minTimes[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int result = new FindMinimumTimetoReachLastRoomI().minTimeToReach(new int[][]{
                {0, 0, 0}, {0, 0, 0}
        });
        System.out.println(result);
    }
}
