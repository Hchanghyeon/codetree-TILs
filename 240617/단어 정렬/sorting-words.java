import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static String[] words;
    private static int N;

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(bufferedReader.readLine());
        words = new String[N];

        for(int i = 0; i < N; i++){
            words[i] = bufferedReader.readLine();
        }

        Arrays.sort(words);
        for(String word: words){
            System.out.println(word);
        }
    }
}