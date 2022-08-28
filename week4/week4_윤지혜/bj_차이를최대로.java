package week4_윤지혜;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class bj_차이를최대로 {

	static int N;
	static int[] nums;
	static int[] numbers;
	static boolean[] visited;
	
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String[] line = br.readLine().split(" ");
		nums = new int[N];
		for(int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(line[n]);
		}
		
		numbers = new int[N];
		visited = new boolean[N];
		Perm(0);
		
		System.out.println(max);
	}

	private static void Perm(int cnt) {
		
		if(cnt == N) {
			int sum = 0;
			for(int i = 0; i < N-1; i++) {
				sum += Math.abs(numbers[i]-numbers[i+1]);
			}
			
			max = max < sum ? sum : max;
		}
			
		for(int i = 0; i < nums.length; i++) {
			if(!visited[i]) {
				numbers[cnt] = nums[i];
				visited[i] = true;
				Perm(cnt+1);
				visited[i] = false;
			}
		}
	}
}
