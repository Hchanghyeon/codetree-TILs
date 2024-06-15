import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(bufferedReader.readLine());
        
        int result = recursive(N, 0);
        System.out.println(result);
    }

    private static int recursive(int number, int count){
        if(number <= 1){
            return count;
        }

        if(number % 2 == 0){
            return recursive(number / 2, count + 1);
        } else {
            return recursive((number * 3) + 1, count + 1);
        }
    }
}