import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final List<Position> positions = new ArrayList<>();
    
    private static int N = 0;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0; i < N; i++){
            final String[] line = bufferedReader.readLine().split(" ");
            final int x1 = Integer.parseInt(line[0]);
            final int x2 = Integer.parseInt(line[1]);

            positions.add(new Position(x1, x2));
        }

        // 선분을 끝점(x2) 기준으로 정렬
        Collections.sort(positions, (p1, p2) -> p1.getX2() - p2.getX2());

        int count = 0;
        int lastEnd = -1; // 마지막으로 선택된 선분의 끝점

        for(Position position : positions) {
            // 현재 선분의 시작점이 이전에 선택된 선분의 끝점보다 크거나 같다면 선택
            if(position.getX1() > lastEnd) {
                lastEnd = position.getX2(); // 선택된 선분의 끝점 갱신
                count++;
            }
        }

        System.out.println(count);
    }

    public static class Position {
        private int x1;
        private int x2;

        Position(int x1, int x2){
            this.x1 = x1;
            this.x2 = x2;
        }

        public int getX1(){
            return x1;
        }

        public int getX2(){
            return x2;
        }
    }
}