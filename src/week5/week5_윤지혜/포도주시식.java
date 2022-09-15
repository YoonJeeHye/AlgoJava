package week5.week5_윤지혜;
import java.util.*;

public class 포도주시식{

	static int N;
	static int arr[];
	static int dp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 포도주 잔의 개수
		
		arr = new int[10001];	// N개의 포도주의 양 저장 배열
		for(int i = 1; i < N+1; i++) {
			arr[i] = sc.nextInt();
		}
		
		dp = new int[10001];	// 최대 포도주의 양 저장 dp로 구현
		dp[1] = arr[1];
		dp[2] = arr[1]+arr[2];
		
		if(N == 1) System.out.println(dp[1]);
		else if(N == 2) System.out.println(dp[2]);
		else {
			for(int n = 3; n < N+1; n++) {
				dp[n] = Math.max(Math.max(dp[n-2]+arr[n], dp[n-3]+arr[n-1]+arr[n]), dp[n-1]);
						
			}
			System.out.println(dp[N]);
		}
		
	}
}
