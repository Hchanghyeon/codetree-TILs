import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final List<Integer> list = new LinkedList<>();
    private static int K, N;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        final String[] line = bufferedReader.readLine().split(" ");

        K = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        recursive(0);
    }

    private static void recursive(int length){
        if(length == N){
            printList();
            return;
        }

        for(int i = 1; i <= K; i++){
            list.add(i);
            recursive(length + 1);
            list.remove(list.size() - 1);
        }
    }

    private static void printList(){
        for(Integer num : list){
            System.out.print(num + " ");
        }

        System.out.println();
    }
}