import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final String MESSAGE = "HelloWorld";

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(bufferedReader.readLine());

        recursive(N);
    }

    private static void recursive(int N){
        if(N == 0){
            return;
        }

        recursive(N - 1);
        System.out.println(MESSAGE);
    }
}