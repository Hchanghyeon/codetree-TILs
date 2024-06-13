import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;
    private static int[] numbers;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = recursive(0, 0);
        System.out.println(max);
    }

    private static int recursive(int index, int max){
        if(index == N){
            return max;
        }

        return recursive(index + 1, Math.max(numbers[index], max));
    }
}