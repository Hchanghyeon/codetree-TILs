import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] resultArray;
    private static String[][] inputArray;
    private static int MAX = 2000;
    private static int OFFSET = 1000;

    public static void main(String[] args) throws Exception {
        inputArray = new String[3][4];

        for(int i = 0; i < 3; i++){
            inputArray[i] = bufferedReader.readLine().split(" ");
        }

        resultArray = new int[MAX][MAX];

        for(int i = 1; i <= 3; i++){
            check(inputArray[i-1], i);
        }

        int result = 0;
        for(int i = 1; i <= 2; i++){
            result += resultProcess(inputArray[i-1], i);
        }

        System.out.println(result);
    }

    private static void check(String[] array, int index){
        int x1 = Integer.parseInt(array[0]) + OFFSET;
        int y1 = Integer.parseInt(array[1]) + OFFSET;
        int x2 = Integer.parseInt(array[2]) + OFFSET;
        int y2 = Integer.parseInt(array[3]) + OFFSET;

        for(int i = y1; i < y2; i++){
            for(int j = x1; j < x2; j++){
                resultArray[i][j] = index;
            }
        }
    }

    private static int resultProcess(String[] array, int index){
        int count = 0;

        int x1 = Integer.parseInt(array[0]) + OFFSET;
        int y1 = Integer.parseInt(array[1]) + OFFSET;
        int x2 = Integer.parseInt(array[2]) + OFFSET;
        int y2 = Integer.parseInt(array[3]) + OFFSET;

        for(int i = y1; i < y2; i++){
            for(int j = x1; j < x2; j++){
                if(resultArray[i][j] != 3){
                    count++;
                }
            }
        }

        return count;
    }
}