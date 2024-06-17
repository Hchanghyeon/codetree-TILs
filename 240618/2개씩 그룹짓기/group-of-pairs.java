import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0, sum = 0;
    private static int[] numbers;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);

        int count = 1;
        int prev = numbers[numbers.length - 1];
        sum += prev;

        for(int i = numbers.length - 2; i >= 0; i--){
            if(count == N){
                break;
            }

            if(prev != numbers[i]){
                sum += numbers[i]; 
                count++;
                prev = numbers[i];
            }
        }

        System.out.println(sum);
    }
}