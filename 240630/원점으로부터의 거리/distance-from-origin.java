import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static Position[] positions;
    private static int N = 0;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());
        positions = new Position[N];

        for(int i = 0; i < N; i++){
            String[] line = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            positions[i] = new Position(i + 1, x, y, x - 0 + y - 0);
        }

        Arrays.sort(positions);
        for(Position position : positions){
            System.out.println(position.id);
        }
    }

    static class Position implements Comparable<Position>{
        private int id;
        private int x;
        private int y;
        private int manhattanValue;

        public Position(int id, int x, int y, int manhattanValue){
            this.id = id;
            this.x = x;
            this.y = y;
            this.manhattanValue = manhattanValue;
        }

        public int compareTo(Position position){
            if(this.manhattanValue != position.manhattanValue){
                return this.manhattanValue - position.manhattanValue;
            } 

            return this.id - position.id;
        }
    }
}