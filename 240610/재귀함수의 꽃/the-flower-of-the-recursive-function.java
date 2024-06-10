import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int number = 0;

    public static void main(String[] args) throws Exception {
        number = Integer.parseInt(bufferedReader.readLine());

        recursive(number);
    }

    private static void recursive(int currentNumber){
        if(currentNumber == 0){
            return;
        }

        System.out.print(currentNumber + " ");
        recursive(currentNumber - 1);
        System.out.print(currentNumber + " ");
    }
}