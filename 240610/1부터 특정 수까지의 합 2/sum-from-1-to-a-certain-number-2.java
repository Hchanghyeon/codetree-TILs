import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(bufferedReader.readLine());

        int result = recursive(0, 1);
        System.out.println(result);
    }

    private static int recursive(int sum, int currentNumber){
        if(currentNumber == N + 1){
            return sum;
        }

        return recursive(sum + currentNumber, currentNumber + 1);
    }
}