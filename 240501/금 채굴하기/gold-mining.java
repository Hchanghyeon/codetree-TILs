import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.*;

import javax.swing.text.Position;

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

        for(int i = 0; i < n; i++){
            map[i] = Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mining(j, i);
            }
        }

        System.out.println(max);
    }

    private static void mining(int x, int y){
        final Deque<Position> queue = new ArrayDeque<>();
        visited = new boolean[n][n];
        int currentK = 0;

        Position position = new Position(new int[]{x, y}, currentK);
        queue.add(position);
        int count = 0;

        while(!queue.isEmpty()){
            while(true){
                Position curPosition = queue.poll();

                if (currentK != curPosition.getK()) {
                    queue.addFirst(curPosition);
                    break;
                }

                int curX = curPosition.getCoordinate()[0];
                int curY = curPosition.getCoordinate()[1];

                for (int i = 0; i < 4; i++) {
                    int nextX = dx[i] + curX;
                    int nextY = dy[i] + curY;

                    if (!isBoundary(nextX, nextY)) {
                        return;
                    }

                    if (visited[nextY][nextX]) {
                        continue;
                    }

                    if (map[nextY][nextX] == 1) {
                        count++;
                    }

                    visited[nextY][nextX] = true;
                    Position newPosition = new Position(new int[] {nextX, nextY}, currentK + 1);
                    queue.add(newPosition);
                }
            }

            currentK++;
            int cost = calculateCost(currentK, count);
            if(cost >= 0){
                max = Math.max(max, count);
            }
        }
    }

    private static int calculateCost(int k, int count){
        return (count * m) - (k * k + (k + 1) * (k + 1));
    }

    private static boolean isBoundary(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static class Position {
        int[] coordinate;
        int k;

        Position(int[] coordinate, int k){
            this.coordinate = coordinate;
            this.k = k;
        }

        public int[] getCoordinate(){
            return coordinate;
        }

        public int getK(){
            return k;
        }
    }
}