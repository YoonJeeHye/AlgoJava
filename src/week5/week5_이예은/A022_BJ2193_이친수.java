package week5.week5_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class A022_BJ2193_이친수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N];
		long result = 0;
		
		if(N <= 2) {
			result = 1;
		} else {
			dp[0] = 1;
			dp[1] = 1;
			for(int i = 2; i < N; i++) {
				dp[i] = dp[i-2] + dp[i-1];
			}
			result = dp[N-1];
		}
		/*---------------출력----------------*/
		bw.write(result + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
