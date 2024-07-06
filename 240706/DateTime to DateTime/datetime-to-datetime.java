import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] inputLine = bufferedReader.readLine().split(" ");

        int day = Integer.parseInt(inputLine[0]);
        int hour = Integer.parseInt(inputLine[1]);
        int minute = Integer.parseInt(inputLine[2]);

        int referenceInSeconds = 11 * 24 * 60 + 11 * 60 + 11;
        int givenTimeInSeconds = day * 24 * 60 + hour * 60 + minute;

        int difference = (givenTimeInSeconds - referenceInSeconds);

        if (difference < 0) {
            System.out.println(-1);
        } else {
            System.out.println(difference);
        }
    }
}