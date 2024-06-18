import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] numbers;
    private static int[] result;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        result = new int[N];

        for(int i = 0; i < N; i++){
            result[i] = numbers[i];

            if((i + 1) % 2 != 0){
                Arrays.sort(result, 0, i + 1);
                System.out.print(result[i / 2] + " ");
            }
        }
    }
}