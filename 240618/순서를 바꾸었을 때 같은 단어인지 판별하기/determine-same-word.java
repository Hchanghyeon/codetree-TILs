import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String word1 = bufferedReader.readLine();
        String word2 = bufferedReader.readLine();

        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        word1 = new String(char1);
        word2 = new String(char2);
        
        if(word1.equals(word2)){
            System.out.println("Yes");
            return;
        } 
        
        System.out.println("No");
    }
}