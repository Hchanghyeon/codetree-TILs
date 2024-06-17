import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0, sum = 0;
    private static Integer[] numbers;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        Arrays.sort(numbers);
        
        for(int i = 0; i < numbers.length / 2; i++){
            sum = Math.max(sum, numbers[i] + numbers[numbers.length - 1 - i]);
        }

        System.out.println(sum);
    }
}