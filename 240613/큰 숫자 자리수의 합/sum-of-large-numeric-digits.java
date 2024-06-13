import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static String[] line;

    public static void main(String[] args) throws Exception {
        line = bufferedReader.readLine().split(" ");
        
        int result = recursive(line.length - 1);
        int sum = sumNumber(result);
        System.out.println(sum);
    }

    private static int recursive(int index){
        if(index == 0){
            return Integer.parseInt(line[index]);
        }

        return recursive(index - 1) * Integer.parseInt(line[index]);
    }

    private static int sumNumber(int number){
        if(number / 10 == 0){
            return number % 10;
        }

        return sumNumber(number / 10) + number % 10;
    }
}