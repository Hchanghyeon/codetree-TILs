import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String[] line = bufferedReader.readLine().split(" ");

        int num1 = Integer.parseInt(line[0]);
        int num2 = Integer.parseInt(line[1]);

        for(int i = 1; i <= 100; i++){
            if(i % num1 == 0 && i % num2 == 0){
                System.out.println(i);
                break;
            }
        }
    }
}