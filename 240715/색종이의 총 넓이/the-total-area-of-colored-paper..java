import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static int[][] array;
    private static int MAX = 200;
    private static int OFFSET = 100;
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        array = new int[MAX][MAX];

        int number = Integer.parseInt(bufferedReader.readLine());

        int result = 0;
        for(int i = 0; i < number; i++){
            result += checkProcess();
        }

        System.out.println(result);
    }

    private static int checkProcess() throws Exception {
        int count = 0;
        String[] input = bufferedReader.readLine().split(" ");

        int x1 = Integer.parseInt(input[0]) + OFFSET;
        int y1 = Integer.parseInt(input[1]) + OFFSET;

        for(int i = y1; i < y1 + 8; i++){
            for(int j = x1; j < x1 + 8; j++){
                if(array[i][j] == 0){
                    array[i][j] = 1;
                    count++;
                }
            }
        }

        return count;
    }
}