import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        final int N = Integer.parseInt(bufferedReader.readLine());

        final int result = progress(N);
        System.out.println(result);
    }

    private static int progress(int N){
        int sum = 0;

        for(int i = 1; i <= N; i++){
            sum += i;
        }

        return sum / 10;
    }
}