import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bufferedReader.readLine().split(" ");
        int num1 = Integer.parseInt(line[0]);
        int num2 = Integer.parseInt(line[1]);

        if(num1 > num2){
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }

        for(int i = num2; i >= 1; i--){
            if(num2 % i == 0 && num1 % i == 0){
                System.out.println(i);
                break;
            }
        }
    }
}