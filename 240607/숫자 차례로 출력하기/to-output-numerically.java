import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(bufferedReader.readLine());

        recursiveAsc(1);
        System.out.println();
        recursiveDesc(N);
    }

    private static void recursiveAsc(int currentNumber){
        if(currentNumber == N + 1){
            return;
        }

        System.out.print(currentNumber + " ");
        recursiveAsc(currentNumber + 1);
    }

    private static void recursiveDesc(int currentNumber){
        if(currentNumber == 0){
            return;
        }

        System.out.print(currentNumber + " ");
        recursiveDesc(currentNumber - 1);
    }
}