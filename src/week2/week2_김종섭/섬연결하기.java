package week2.week2_김종섭;

import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {
	
	public static int[] id;
	
	public static int root(int i) {
		while(i != id[i]) i = id[i];
		return i;
	}
	
	public static void QUnion (int p, int q) {
		id[root(p)] = root(q);
	}
	
	public static boolean isConnected(int p, int q) {
		return root(p) == root(q);
	}

	public int solution(int n, int[][] costs) {
        
		Arrays.sort(costs, new Comparator<int[]>() {

	        
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
			
		id = new int [n+1];
        for (int i = 1; i <= n; i++) {
			id[i] = i;
		}
		int sum = 0;
        
        for (int[] arr : costs) {
			if(isConnected(arr[0], arr[1])) continue;
			else {
				QUnion(arr[0], arr[1]);
				sum += arr[2];
			}
		}
        
        
        return sum;
    }
	
	public static void main(String[] args) {
		섬연결하기 ar = new 섬연결하기();
		int [][] costs = new int [][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int n = 4;
		
		System.out.println(ar.solution(n, costs));
	}

}
