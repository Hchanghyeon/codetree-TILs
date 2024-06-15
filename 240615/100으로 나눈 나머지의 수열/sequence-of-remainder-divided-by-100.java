import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(bufferedReader.readLine());
        
        int result = recursive(2, 4, 2);
        System.out.println(result);
    }

    private static int recursive(int prev, int next, int count){
        if(count == N + 1){
            return prev;
        }

        return recursive(next, (prev * next) % 100, count + 1);
    }
}