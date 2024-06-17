import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;
    private static int k = 0;
    private static int[] numbers;

    public static void main(String[] args) throws Exception {
        final String[] firstLine = bufferedReader.readLine().split(" ");
        
        N = Integer.parseInt(firstLine[0]);
        k = Integer.parseInt(firstLine[1]);

        numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);

        System.out.println(numbers[k - 1]);
    }
}