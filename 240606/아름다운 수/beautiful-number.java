import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final List<Integer> numbers = new ArrayList<>();
    private static int N = 0, result = 0;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());

        recursive(0);
        System.out.println(result);
    }

    private static void recursive(int length){
        if(length == N){
            if(findBeautifulNumber()){
                result++;
            }
            return;
        }

        for(int i = 1; i <= 4; i++){
            numbers.add(i);
            recursive(length + 1);
            numbers.remove(numbers.size() - 1);
        }
    }

    private static boolean findBeautifulNumber(){
        int prev = numbers.get(0);
        int count = 1;

        for(int i = 1; i < numbers.size(); i++){
            if(prev == numbers.get(i)){
                count++;
            } else {
                if(count % prev != 0){
                    if(count != prev){
                    return false;
                }
                }
                count = 1;
            }

            prev = numbers.get(i);
        }

        if(count % prev == 0){
             return true;
        }
     
        return count == prev;
    }
}