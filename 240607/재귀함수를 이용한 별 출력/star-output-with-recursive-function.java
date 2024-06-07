import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final String str = "*";
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        count = Integer.parseInt(bufferedReader.readLine());
        
        recursive(1);
    }

    private static void recursive(int number){
        if(count == number + 1){
            return;
        }

        final StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < number; i++){
            stringBuffer.append("*");
        }

        System.out.println(stringBuffer.toString());
        recursive(number + 1);
    }
}