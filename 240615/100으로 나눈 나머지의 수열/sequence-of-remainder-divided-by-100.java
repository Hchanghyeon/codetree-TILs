import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(bufferedReader.readLine());
        
        int result = recursive(N);
        System.out.println(result);
    }

    private static int recursive(int number){
        if(number == 1){
            return 2;
        }

        if(number == 2){
            return 4;
        }

        return recursive(number - 1) * recursive(number - 2) % 100;
    }
}