package week5.week5_윤지혜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 피보나치
public class 이친수 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long dp[] = new long[N+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i < N+1; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		System.out.println(dp[N]);
		
	}
}
