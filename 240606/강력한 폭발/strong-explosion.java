import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final List<Integer> numbers = new ArrayList<>();
    private static final List<int[]> positions = new ArrayList<>();
    private static int max = 0;
    private static final int[][] dx = {
        {0, 0, 0, 0},
        {0, 0, -1, 1},
        {-1, 1, 1, -1}
    };
    private static final int[][] dy = {
        {-1, -2, 1, 2},
        {-1, 1, 0, 0},
        {-1, -1, 1, 1}
    };

    private static int N = 0;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1){
                    positions.add(new int[]{j, i});
                }
            }
        }

        recursive(0);

        System.out.println(max);
    }

    private static void recursive(int depth){
        if(depth == positions.size()){
            visited = new boolean[N][N];
            int count = 0;

            for(int i = 0; i < positions.size(); i++){
                processBomb(positions.get(i), numbers.get(i));
            }

            for(int k = 0; k < N; k++){
                for(int j = 0; j < N; j++){
                    if(visited[k][j]) {
                        count++;
                    }
                }
            }

            max = Math.max(count, max);

            return;
        }

        for(int i = 0; i < 3; i++){
            numbers.add(i);
            recursive(depth + 1);
            numbers.remove(numbers.size() - 1);
        }
    }

    private static void processBomb(int[] position, int number){
        int[] mx = dx[number];
        int[] my = dy[number];

        visited[position[1]][position[0]] = true;
      
        for(int i = 0; i < 4; i++){
            int nextX = mx[i] + position[0];
            int nextY = my[i] + position[1];

            if(nextX < N && nextY < N && nextX >= 0 && nextY >= 0 && !visited[nextY][nextX]){
                visited[nextY][nextX] = true;
            }
        }
    }
}