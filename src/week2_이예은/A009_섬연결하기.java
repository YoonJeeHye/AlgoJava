package week2_이예은;

import java.util.PriorityQueue;

class A009_섬연결하기 {

   static int[] parent; //Union-Find 알고리즘을 활용해서 풀 수 있다 ^^^
	
	public static void union(int a, int b) {// 2개의 노드가 하나의 집합을 이룬다
		a = find(a);// 부모 노드를 찾는다
		b = find(b);
		if(a > b) 
			parent[a] = b;
		else
			parent[b] = a;
	}
	
	public static int find(int x) {// 부모찾기, 같은 집합인지 찾는다
		if(parent[x] == x)
			return x;
		else
			return find(parent[x]);
	}
	

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue <int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        // MaxHeap 선언
     
        for(int i = 0; i < costs.length; i++) {// 비용, node1, node2 순으로 넣어준다
        	pq.offer(new int[] {costs[i][2], costs[i][0], costs[i][1]});
        }

        parent = new int[n]; // 부모노드 초기화
        for(int i = 0; i < n; i++)
        	parent[i] = i;
        
        while(!pq.isEmpty()) {
        	int[] temp = pq.poll(); // priority queue에서 cost가 적은 순으로 하나씩 poll한다
        	int cost = temp[0];
        	int node1 = temp[1];
        	int node2 = temp[2];
        	
        	if(find(node1) == find(node2)) continue;
            //  만약 두 노드가 같은 집합에 있다면 계속 탐색한다
        	
        	union(node1, node2); // 아니라면 두 노드를 같은 집합에 넣고
        	answer += cost;// 비용을 추가한다
        }
        return answer;
    }
}