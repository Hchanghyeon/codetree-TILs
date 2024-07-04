import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    public static void main(String[] args) throws Exception {
        String[] inputLine = bufferedReader.readLine().split(" ");
        
        int m1 = Integer.parseInt(inputLine[0]);
        int d1 = Integer.parseInt(inputLine[1]);
        int m2 = Integer.parseInt(inputLine[2]);
        int d2 = Integer.parseInt(inputLine[3]);

        int sum1 = 0;
        int sum2 = 0;

        for(int i = 0; i < m2 - 1; i++){
            sum2 += months[i];
        }
        sum2 += d2;

        for(int i = 0; i < m1 - 1; i++){
            sum1 += months[i];
        }
        sum1 += d1;

        System.out.println(sum2 - sum1 + 1);
    }
}