import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static Integer[] numbers;
    private static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        
        Arrays.sort(numbers);
        printArray();
        Arrays.sort(numbers, Collections.reverseOrder());
        printArray();
    }

    private static void printArray(){
        for(Integer number : numbers){
            System.out.print(number + " ");
        }
        System.out.println();
    }
}