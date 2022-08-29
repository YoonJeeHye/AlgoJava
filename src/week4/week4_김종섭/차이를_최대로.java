package august_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 차이를_최대로 {
	static int N, max, sum;
	static int[] arr, ans;
	static boolean [] isVisited;
	public static void Permutation(int index) {
		if(index == N) {
			sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(ans[i] - ans[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			ans[index] = arr[i];
			Permutation(index+1);
			isVisited[i] = false;
		}
		
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N];  ans = new int [N];
		sum = 0; max = Integer.MIN_VALUE;
		isVisited = new boolean [N];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		Permutation(0);
		System.out.println(max);
	}

}
