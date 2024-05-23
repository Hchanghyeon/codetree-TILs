import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[46];
        int number = Integer.parseInt(bufferedReader.readLine());

        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i < 45; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[number]);
    }
}