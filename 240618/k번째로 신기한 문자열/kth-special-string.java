import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static String T;
    private static String[] words, result;

    public static void main(String[] args) throws Exception {
        String[] firstLine = bufferedReader.readLine().split(" ");

        n = Integer.parseInt(firstLine[0]);
        k = Integer.parseInt(firstLine[1]);
        T = firstLine[2];

        words = new String[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            String word = bufferedReader.readLine();

            if(word.startsWith(T)){
                words[i] = word;
                count++;
            }
        }

        result = new String[count];
        int i = 0;

        for(String word : words){
            if(word != null){
                result[i] = word;
                i++;
            }
        }

        Arrays.sort(result);

        System.out.println(result[k - 1]);
    }
}