package week4.week4_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A020_BJ10819_차이를최대로 {
	
	static int N;
	static int[] nums;
	static int result = Integer.MIN_VALUE;
	
	public static void permutation(int cnt, boolean[] visited, int[] path) {
		if(cnt == N) {
			int total = 0;
			for(int i = 0; i < N-1; i++) { // 계산한다
				total += Math.abs((nums[path[i]] - nums[path[i+1]]));
			}
			result = result < total ? total: result; // 최대 차이 값을 갱신한다
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				path[cnt] = i;
				permutation(cnt+1, visited, path);
				visited[i] = false;
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		String[] inputs = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(inputs[i]);
		}
		/*---------------입력 끝----------------*/
		
		permutation(0, new boolean[N], new int[N]); // N이 최대 8 이기 때문에 순열로 풀수 있다

		/*---------------출력----------------*/
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
