import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    private static int[][] map;
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bufferedReader.readLine());
        map = new int[count][count];
        int max = 0;

        for(int i = 0; i < count; i++){
            map[i] = Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < count; i++){
            for(int j = 0; j < count; j++){
                int returnNumber = process(j, i);
                if(returnNumber > max){
                    max = returnNumber;
                }
            }
        }

        System.out.println(max);
    }

    private static int process(int x, int y){
        int sum = 0;

        if(x + 2 < count && y + 2 < count){
            for(int i = y; i < y + 3; i++){
                for(int j = x; j < x + 3; j++){
                    if(map[i][j] == 1){
                        sum++;
                    }
                }
            }
        }

        return sum;
    }
}