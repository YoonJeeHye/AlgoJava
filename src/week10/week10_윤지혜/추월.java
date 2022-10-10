package week10.week10_윤지혜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 추월 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] carIn = new String[N];
		for(int n = 0; n < N; n++) {
			String line = br.readLine();
			carIn[n] = line;
		}
		
		// 나오는 차는 거꾸로 담기
		String[] carOut = new String[N];
		for(int n = 2*N-1; n >= N; n--) {
			String line = br.readLine();
			carOut[n-N] = line;
		}
		
		boolean[] visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			for(int n = 0; n < N; n++) {
				if(carIn[i].equals(carOut[n])) {
					for(int j = i+1; j < N; j++) {
						for(int m = n+1; m < N; m++) {
							if(carIn[j].equals(carOut[m])) {
								visited[m] = true;
							}
						}
					}
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i < N; i++) {
			if(visited[i] == true) answer++;
		}
		
		System.out.println(answer);
	}
	
}