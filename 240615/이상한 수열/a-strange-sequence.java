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
        if(number == 1) {
            return 1;
        }
        if(number == 2){
            return 2;
        }

        return recursive(number / 3) + recursive(number - 1);
    }
}