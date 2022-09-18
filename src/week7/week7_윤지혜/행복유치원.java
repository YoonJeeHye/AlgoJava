package week7.week7_윤지혜;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 모르겠어여
public class 행복유치원{

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);
		
		int arr[] = new int[N];
		line = br.readLine().split(" ");
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(line[n]);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 1; i <= N; i++) {
			pq.offer(arr[i]-arr[i-1]);
		}
	}


}