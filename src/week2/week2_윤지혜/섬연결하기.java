package week2.week2_윤지혜;

import java.util.*;

// 크루스칼 알고리즘
// 1. 최소 비용부터 오름차순으로 정리
// 2. 순서대로 넣되, 사이클이 생기는 경우는 넣지 않는다.

public class 섬연결하기 {
	
	static void union(int[] parent, int a, int b) {	// 부모 갱신해주기
		int a_parent = find(parent, a);
		int b_parent = find(parent, b);
		
		if(a_parent < b_parent) {
			parent[b_parent] = a_parent;
		}else {
			parent[a_parent] = b_parent;
		}
	}
	
	static int find(int[] parent, int i) {	// i의 부모 찾기
		if(parent[i] == i) return i;
		return find(parent, parent[i]);
	}
	
	
	public static int solution(int n, int[][] costs) {
		
		int answer = 0;
		int parent[] = new int[n];
		
		for(int i = 0; i < parent.length; i++) {	// 초기 : 자신의 부모는 자신
			parent[i] = i;
		}
		
		Arrays.sort(costs, new Comparator<int[]>() {	// 가중치 기준으로 오름차순 정리

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		for(int i = 0; i < costs.length; i++) {
			if(find(parent, costs[i][0]) != find(parent, costs[i][1])) {	// 사이클 없다면
				answer += costs[i][2];	// 답에 비용 더해주고
				union(parent, costs[i][0], costs[i][1]);	// 부모 바꿔주기
			}
		}
		return answer;
		
    }

	public static void main(String[] args) {

		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		solution(4, costs);

	}

}
