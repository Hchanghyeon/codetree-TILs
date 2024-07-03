import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        
        String[] numbers = bufferedReader.readLine().split(" ");

        int h1 = Integer.parseInt(numbers[0]); 
        int m1 = Integer.parseInt(numbers[1]);
        int h2 = Integer.parseInt(numbers[2]);
        int m2 = Integer.parseInt(numbers[3]);

        System.out.println(Math.abs((h1 * 60 + m1) - (h2 * 60 + m2)));
    }
}