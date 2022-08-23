import java.util.PriorityQueue;

//1. cost를 오름차순 정렬해서 가장 작은 간선 선택
//2.간선이 사이클,MST 형성하는지 확인 ,아니면 추가
//3. 반복

class Solution {
    static int []parent;//부모노드 확인
	static PriorityQueue<Node> que;//간선 정보 저장
    
    class Node implements Comparable<Node>{
		int start;
		int end;
		int cost;
		
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {//cost 오름차순으로 정렬
			return this.cost-o.cost;
		}
	}//정렬 끝
    
    //부모 노드 찾기(본인이 루트 노드이면 리턴, 아니면 루트 노드 찾아줌)
	public static int find(int v) {
		if(parent[v]==v)return v;
		
		return parent[v] =find(parent[v]);
	}
	
	//union(합치기), 루트 노드가 한쪽으로 합쳐짐
	public static void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if(p1<p2) {
			parent[p2] = p1;
		}else {
			parent[p1] = p2;
		}
	}
    
    public int solution(int n, int[][] costs) {
        //크루스칼 알고리즘
		
		que = new PriorityQueue<>();//간선 정보 저장
		parent = new int[n+1];
		int sum = 0;// cost들의 합
		//부모노드 초기화(처음에는 본인만을 가진 집합이라고 초기화)
		for (int i = 1; i <=n; i++) {
			parent[i] = i;
		}
		//큐에 정렬된 간선 정보 넣기
		for (int i = 0; i < costs.length; i++) {
			que.offer(new Node(costs[i][0],costs[i][1],costs[i][2]));
		}
		while(!que.isEmpty()) {//큐가 빌때까지
			Node current = que.poll();//가중치 작은 간선 뽑아서
			
			//사이클이 만들어지는지 확인
			if(find(current.start)!= find(current.end)) {//두 정점이 같은 집합에 있으면 사이클
				union(current.start,current.end);
				sum+=current.cost;
			}
			
		}
		
		return sum;
    }
}
