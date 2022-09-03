package week5.week5_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class A021_BJ2156_포도주시식 {
	static int N;
	static int[] dp, wine;
	
	public static int total_wine() {
		dp[1] = wine[1];
		if(N == 1) return wine[1]; // 와인이 한개 밖에 없다면 경우의 수가 하나 이다
		
		dp[2] = wine[1] + wine[2];
		for(int i = 3; i <= N; i++) { // 와인이 2개 이상이라면 dp의 표를 채울 수 있다
			// dp[i] = i번째 와인이 들어 있는 컵에 도착 했을때 최대로 많이 먹을 수 있는 와인의 양
			// i번째 와인을 먹을 때
			dp[i] = dp[i-2] < dp[i-3] + wine[i-1]? dp[i-3] + wine[i-1] + wine[i]: dp[i-2] + wine[i];
			// i번째 와인을 먹지 않을 때
			dp[i] = dp[i] < dp[i-1] ? dp[i-1]: dp[i];
		}
		return dp[N];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		wine = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		int result = total_wine();
		/*---------------출력----------------*/
		bw.write(result + "");
		bw.flush();
		br.close();
		bw.close();
	}
}