import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = bufferedReader.readLine().split(" ");
        int y = Integer.parseInt(line[0]);
        int x = Integer.parseInt(line[1]);

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                System.out.print("1");
            }
            System.out.println();
        }
    }
}