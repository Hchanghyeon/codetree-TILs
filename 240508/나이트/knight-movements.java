import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    private static final int[] dx = {-1, -2, 1, 2, 2, 1, -1, -2};
    private static final int[] dy = {-2, -1, -2, -1, 1, 2, 2, 2};
    private static int N, destinationX, destinationY, result = -1;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
            
        final int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        destinationX = line[2] - 1;
        destinationY = line[3] - 1;

        bfs(line[1] - 1, line[0] - 1);

        System.out.println(result);
    }

    private static void bfs(int x, int y){
        if(x == 0 && y == 0 && destinationX == 0 && destinationY == 0){
            result = 0;
            return;
        }


        final Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{x, y});
        visited[y][x] = true;

        while(!deque.isEmpty()){
            int[] currentPosition = deque.poll();

            for(int i = 0; i < 8; i++){
                int nx = dx[i] + currentPosition[0];
                int ny = dy[i] + currentPosition[1];

                if(isBoundary(nx, ny)){
                    visited[ny][nx] = true;
                    map[ny][nx] = map[currentPosition[1]][currentPosition[0]] + 1;
                    deque.addLast(new int[]{nx, ny});

                    if(nx == destinationX && ny == destinationY){
                        result = map[ny][nx];
                        deque.clear();
                        break;
                    }
                }
            }
        }
    }

    private static boolean isBoundary(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N && !visited[y][x];
    }
}