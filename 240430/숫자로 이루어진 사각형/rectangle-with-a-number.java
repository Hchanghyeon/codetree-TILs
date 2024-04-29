import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int count = Integer.parseInt(bufferedReader.readLine());

        int currentNumber = 1;
        for(int i = 0; i < count; i++){
            for(int j = 0; j < count; j++){
                System.out.print(currentNumber + " ");
                if(currentNumber == 9){
                    currentNumber = 1;
                    continue;
                }

                currentNumber++;
            }
            System.out.println();
        }
    }
}