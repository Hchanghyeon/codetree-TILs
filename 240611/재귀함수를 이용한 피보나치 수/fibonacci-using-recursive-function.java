import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(bufferedReader.readLine());
        if(N == 1 || N == 2){
            System.out.println(1);
            return;
        }

        int result = recursive(1, 1, 2);
        System.out.println(result);
    }

    private static int recursive(int num1, int num2, int count){
        if(N == count){
            return num2;
        }

        return recursive(num2, num1 + num2, count + 1);
    }
}