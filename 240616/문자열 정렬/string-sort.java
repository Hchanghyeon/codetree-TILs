import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        final String str = bufferedReader.readLine();
        char[] characters = str.toCharArray();

        Arrays.sort(characters);
        System.out.println(new String(characters));
    }
}