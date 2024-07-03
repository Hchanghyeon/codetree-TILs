import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine().split(" ")[0]);
        String[] inputNumbers = bufferedReader.readLine().split(" ");
        Number[] numbers = new Number[N];

        for(int i = 0; i < N; i++){
            numbers[i] = new Number(i, Integer.parseInt(inputNumbers[i]));
        }

        Arrays.sort(numbers);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == numbers[j].prevIndex){
                    System.out.print(j + 1 + " ");
                    break;
                }
            }
        }
    }

    static class Number implements Comparable<Number>{
        private int prevIndex;
        private int value;

        public Number(int prevIndex, int value){
            this.prevIndex = prevIndex;
            this.value = value;
        }

        public int compareTo(Number number){
            return this.value - number.value;
        }
    }
}