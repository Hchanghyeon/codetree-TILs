import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.stream.Stream;
import java.util.*;

public class Main {
    private static final List<int[][]> blocks = Arrays.asList(
        new int[][]{{-1,-1}, {0, 1}},
        new int[][]{{0, -1}, {1, 0}},
        new int[][]{{0, -1}, {1, 1}},
        new int[][]{{0, 1}, {1, 1}},
        new int[][]{{0, 0}, {1, -1}},
        new int[][]{{1, -1}, {0, 0}}
    );

    private static int[][] map;
    private static int height = 0;
    private static int width = 0;
    private static int max = 0;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] line = bufferedReader.readLine().split(" ");

        height = Integer.parseInt(line[0]);
        width = Integer.parseInt(line[1]);

        map = new int[height][width];

        for(int i = 0; i < height; i++){
            map[i] = Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                checkBlock(j, i);
            }
        }

        System.out.println(max);
    }

    private static void checkBlock(int width, int height){
        for(int[][] block : blocks){
            int sum = map[height][width];
            int[] blockY = block[0];
            int[] blockX = block[1];

            for(int i = 0; i < 2; i++){
                int nextY = blockY[i] + height;
                int nextX = blockX[i] + width;

                if(!isBoundary(nextX, nextY)){
                    return;
                }

                sum += map[nextY][nextX];
            }

            max = Math.max(max, sum);
        }
    }

    private static boolean isBoundary(int nextX, int nextY){
        return nextX >= 0 && nextX < width && nextY >= 0 && nextY < height;
    }
}