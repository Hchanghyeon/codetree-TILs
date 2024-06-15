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

        System.out.println(recursive(Arrays.stream(numbers).max().orElse(0)));
    }

    private static int recursive(int number){

        for(int num : numbers){
            if(number % num != 0){
                return recursive(number + 1);
            }
        }

        return number;
    }
}