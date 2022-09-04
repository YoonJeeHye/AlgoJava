import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		int[] drink = new int[n + 1];
		int[] dp = new int[n + 1];
		dp[0] = 0;
		drink[0] = 0;
		for (int i = 1; i <= n; i++) {
			if (i == 1 || i == 2) {
				drink[i]=Integer.parseInt(bufferedReader.readLine());
				dp[i] = dp[i - 1] + drink[i];
			} else {
				drink[i] = Integer.parseInt(bufferedReader.readLine());
				dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3] + drink[i - 1]) + drink[i], dp[i - 1]);
			}
		}
		System.out.println(dp[n]);
	}

}
