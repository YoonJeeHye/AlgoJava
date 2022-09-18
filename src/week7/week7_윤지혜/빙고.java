package week7.week7_윤지혜;

import java.util.*;

public class 빙고{
	
	static int[][] arr;
	static int[] check;
	static int cnt;
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		// 철수 빙고판
		arr = new int[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int answer = 0;
		cnt = 0;
		check = new int[12];	// 5 -> 행, 5 -> 열, 2 -> 대각선
		
		while(cnt<3) {
			
			int N = sc.nextInt();	// 사회자가 부른 숫자
			answer++;
			
			find(N);
		
		}
		
		System.out.println(answer);
		
	}
	private static void find(int N) {
		for(int m = 0; m < 5; m++) {
			for(int n = 0; n < 5; n++) {
				if(arr[m][n] == N) {
					
					check[m]++;		// 행
					check[n+5]++;	// 열
					// 대각선
					if(m == n) check[10]++;
					if(m + n == 4) check[11]++;
					
					if(check[m] == 5) {
						cnt++;
						check[m] = -1;
					}
					if(check[n+5] == 5) { 
						cnt++;
						check[n] = -1;
					}
					if(check[10] == 5) {
						cnt++;
						check[10] = -1;
					}
					if(check[11] == 5) {
						cnt++;
						check[11] = -1;
					}
					
					return;
				}
			}
		}
	}

}
