import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.stream.Stream;

public class Main {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] belt;
    private static int beltFloor = 2;
    private static int beltCount, second, firstTemp, secondTemp;

    public static void main(String[] args) throws Exception {
        String[] line = bufferedReader.readLine().split(" ");
        
        beltCount = Integer.parseInt(line[0]);
        second = Integer.parseInt(line[1]);

        belt = new int[beltFloor][beltCount];
        belt[0] = Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] secondBelt = bufferedReader.readLine().split(" ");

        for(int i = 0; i < beltCount; i++){
            belt[1][i] = Integer.parseInt(secondBelt[(beltCount - 1) - i]);
        }
    
        for(int i = 0; i < second; i++){
            processMove();
        }  


        for(int j = 0; j < beltCount; j++){
            System.out.print(belt[0][j] + " ");
        }
        System.out.println();
        for(int j = beltCount - 1; j >= 0; j--){
            System.out.print(belt[1][j] + " ");
        }
    }

    private static void processMove(){
        firstTemp = belt[0][beltCount - 1]; // 3
        secondTemp = belt[1][0]; // 1

        for(int i = beltCount - 1; i > 0; i--){
            belt[0][i] = belt[0][i - 1];
        }

        for(int i = 0; i < beltCount - 1; i++){
            belt[1][i] = belt[1][i + 1];
        }

        belt[0][0] = secondTemp;
        belt[1][beltCount - 1] = firstTemp;
    }
}