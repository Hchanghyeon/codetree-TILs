import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static int MAX = 1_001;

    public static void main(String[] args) throws Exception {  
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] dp = new int[MAX];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4; i < MAX; i++){
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }    

        System.out.println(dp[n]);
    }
}