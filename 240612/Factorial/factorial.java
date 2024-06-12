import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(bufferedReader.readLine());

        System.out.println(recursive(N));
    }

    private static int recursive(int number){
        if(number == 0){
            return 1;
        }
        
        return recursive(number - 1) * number;
    }
}