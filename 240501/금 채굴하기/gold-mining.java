import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    private static int n, m, max;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        final String[] line = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mining(j, i);
                for (boolean[] row : visited) {  // Reset visited after each mining operation
                    Arrays.fill(row, false);
                }
            }
        }

        System.out.println(max);
    }

    private static void mining(int x, int y) {
        // visited 초기화 이동

        Deque<int[]> queue = new ArrayDeque<>();
        int currentK = 1;

        queue.add(new int[]{x, y, currentK});
        visited[y][x] = true;

        int count = map[y][x] == 1 ? 1 : 0;

        while (!queue.isEmpty()) {
            int[] curPos = queue.pollFirst();
            int curX = curPos[0];
            int curY = curPos[1];
            int k = curPos[2];

            if (k > currentK) {
                int cost = calculateCost(currentK, count);
                if (cost >= 0) {
                    max = Math.max(max, count);
                }
                currentK = k;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + curX;
                int nextY = dy[i] + curY;

                if (!isBoundary(nextX, nextY) || visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;
                if (map[nextY][nextX] == 1) {
                    count++;
                }

                queue.add(new int[]{nextX, nextY, k + 1});
            }
        }

        // 마지막 깊이에서도 비용 계산
        int cost = calculateCost(currentK, count);
        if (cost >= 0) {
            max = Math.max(max, count);
        }
    }

    private static int calculateCost(int k, int count){
        return (count * m) - (k * k + (k + 1) * (k + 1));
    }

    private static boolean isBoundary(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}