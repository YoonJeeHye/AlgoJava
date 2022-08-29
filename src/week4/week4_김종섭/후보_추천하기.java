package august_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 후보_추천하기 {
	
	public static class banzang implements Comparable<banzang>{
		int name, recommend;

		public banzang(int name, int recommend) {
			super();
			this.name = name;
			this.recommend = recommend;
		}

		@Override
		public int compareTo(banzang o) {
			// TODO Auto-generated method stub
			return this.recommend - o.recommend;
		}

		
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int [] answer = new int [M];
		int [] recommends = new int [101];
		ArrayList<banzang> list = new ArrayList<>();
		
		String [] s = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			answer[i] = Integer.parseInt(s[i]);
			recommends[answer[i]] += 1;
		}
		
		for (int i = 0; i < M; i++) {
			if(recommends[answer[i]]!= 0) {
				
			}else {
				
				
			}
			
			
		}
		
		
		
		System.out.println(list.get(2).name);
	}
}
