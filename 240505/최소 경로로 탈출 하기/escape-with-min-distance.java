import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    
    private static int[][] map;
    private static boolean[][] visited;
    private static int N, M;

    public static void main(String[] args) throws Exception{
        final String[] line = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        search(0, 0);

        int result = map[N-1][M-1];

        if(result <= 1){
            System.out.println(-1);
            return;
        }

        System.out.println(map[N-1][M-1] - 1);
    }

    private static void search(int x, int y){
        final Deque<int[]> deque = new ArrayDeque<>();
        int[] point = new int[]{x, y};
        deque.add(point);
        visited[y][x] = true;

        while(!deque.isEmpty()){
            int[] currentPoint = deque.pollLast();
            
            for(int i = 0; i < 4; i++){
                int nextX = dx[i] + currentPoint[0];
                int nextY = dy[i] + currentPoint[1];

                if(!isBoundary(nextX, nextY)){
                    continue;
                }
                
                visited[nextY][nextX] = true;
                map[nextY][nextX] = map[currentPoint[1]][currentPoint[0]] + 1;
                deque.addLast(new int[]{nextX, nextY});
            }
        }
    }

    private static boolean isBoundary(int x, int y){
        return (x >= 0 && x < M && y >= 0 && y < N) && !visited[y][x] && map[y][x] == 1;
    }
}