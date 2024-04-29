import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String[] line = bufferedReader.readLine().split(" ");

        final int count = Integer.parseInt(line[0]);
        final int result = Integer.parseInt(line[1]);
        final int[][] map = new int[count][count];

        for(int i = 0; i < count; i++){
            map[i] = Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        if(result == 1){
            System.out.println(count * 2);
            return;
        }

        int resultNumber = 0;

        for(int i = 0; i < count; i++){
            int sum = 0;

            for(int j = 0; j < count - 1; j++){
                int current = map[i][j]; // 현재 값

                if(current == map[i][j+1]){ // 이전 값과 현재 값이 동일할 때
                    sum++; // 값 올리기
                    continue;
                } 
                sum = 1; // 값 초기화
            }

            if(sum >= result){
                resultNumber++;
            }
        }

        for(int i = 0; i < count; i++){
            int sum = 0;

            for(int j = 0; j < count - 1; j++){
                int current = map[i][j]; // 현재 값

                if(current == map[i][j+1]){ // 이전 값과 현재 값이 동일할 때
                    sum++; // 값 올리기
                    continue;
                } 
                sum = 1; // 값 초기화
            }

            if(sum >= result){
                resultNumber++;
            }
        }

        System.out.println(resultNumber);
    }
}