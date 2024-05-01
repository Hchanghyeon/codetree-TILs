import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static Deque<Integer> firstBelt = new ArrayDeque();
    private static Deque<Integer> secondBelt = new ArrayDeque();
    private static Deque<Integer> thridBelt = new ArrayDeque();

    public static void main(String[] args) throws Exception {
        String[] line = bufferedReader.readLine().split(" ");
        int beltCount = Integer.parseInt(line[0]);
        int time = Integer.parseInt(line[1]);

        line = bufferedReader.readLine().split(" ");
        addInQueue(line, firstBelt);
        line = bufferedReader.readLine().split(" ");
        addInQueue(line, secondBelt);
        line = bufferedReader.readLine().split(" ");
        addInQueue(line, thridBelt);

        for(int i = 0; i < time; i++){
            processMove();
        }

        for(Integer number : firstBelt){
            System.out.print(number + " ");
        }
        System.out.println();

        for(Integer number : secondBelt){
            System.out.print(number + " ");
        }
        System.out.println();

        for(Integer number : thridBelt){
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void addInQueue(String[] line, Deque<Integer> queue){
        for(int i = 0; i < line.length; i++){
            queue.add(Integer.parseInt(line[i]));
        }
    }

    public static void processMove(){
        secondBelt.addFirst(firstBelt.pollLast());
        thridBelt.addFirst(secondBelt.pollLast());
        firstBelt.addFirst(thridBelt.pollLast());
    }
}