import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        
        int number = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        if(number == 0){
            System.out.println(0);
            return;            
        }

        while(number > 0){
            int temp = number % 2;
            number = number / 2;

            stringBuilder.append(String.valueOf(temp));
        }

        System.out.println(stringBuilder.reverse());
    }
}