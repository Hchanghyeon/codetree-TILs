import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(bufferedReader.readLine());

        recursive(N);
    }

    private static void recursive(int currentNumber){
        if(currentNumber == 0){
            return;
        }

        for(int i = 0; i < currentNumber; i++){
            System.out.print("* ");
        }
        System.out.println();

        recursive(currentNumber - 1);

        for(int i = 0; i < currentNumber; i++){
            System.out.print("* ");
        }
        System.out.println();
    }
}