package week7.week7_윤지혜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 퇴사{

	static int N;
	static int[] T;
	static int[] P;
	static int[] DP;
	public static void main(String[] args) throws Exception {
		
		Input();
		
		DP = new int[N+2];
		
//		for(int i = 1; i <= N; i++) {
//			if(T[i] + i <= N+1) {	// T가 퇴사 전 기간이면
//				DP[i] += P[i];	// 자신의 P는 무조건 넣고
//				DP[i+T[i]] = DP[i] > DP[i+T[i]] ? DP[i] : DP[i+T[i]];	// 현재 일 + T[i]의 DP 갱신
//			}
//		}
		
		// 예제 4번같은 경우 때문에 거꾸로 풀기
		for(int i = N; i >= 1; i--) {
			// T가 퇴사 전 기간이면
			if(T[i] + i <= N+1) DP[i] = Math.max(DP[i+1], DP[i+T[i]]+P[i]);
			else DP[i] = DP[i+1];
		}
		
		System.out.println(DP[1]);
	}
	
	private static void Input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		T = new int[N+1];
		P = new int[N+1];
		for(int i = 1; i <= N; i++) {
			String[] line = br.readLine().split(" ");
			T[i] = Integer.parseInt(line[0]);
			P[i] = Integer.parseInt(line[1]);
		}
	}

}
