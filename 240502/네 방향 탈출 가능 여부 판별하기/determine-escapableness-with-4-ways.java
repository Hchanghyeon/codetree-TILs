import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] directionX = {0, 0, -1, 1};
    private static final int[] directionY = {-1, 1, 0, 0};

    private static int N, M;
    private static int[][] map;

    public static void main(String[] args) throws Exception {
        String[] inputLine = bufferedReader.readLine().split(" ");
        M = Integer.parseInt(inputLine[0]);
        N = Integer.parseInt(inputLine[1]);

        map = new int[M][N];

        for(int i = 0; i < M; i++){
            map[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        bfs(0, 0);

        if(map[M-1][N-1] == 0){
            System.out.println(1);
            return;
        }
        
        System.out.println(0);
    }

    private static void bfs(int x, int y){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        map[y][x] = 0;

        while(!queue.isEmpty()){
            int[] position = queue.pollLast();

            for(int i = 0; i < 4; i++){
                int nextX = directionX[i] + position[0];
                int nextY = directionY[i] + position[1];

                if(!isBoundary(nextX, nextY)){
                    continue;
                }

                map[nextY][nextX] = 0;
                queue.add(new int[]{nextX, nextY});
            }
        }
    }

    private static boolean isBoundary(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M && map[y][x] == 1;
    }
}