package week5.week5_이예은;

import java.util.PriorityQueue;

public class A023_카카오인턴_경주로건설 {

	
	public static class Node implements Comparable<Node> {
		int y, x, cost, d;

		public Node(int y, int x, int d, int cost) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			if(this.cost == o.cost) {
				if(this.y == o.y) {
					return o.x - this.x;
				}
				return o.y - this.y;
			}
			return this.cost - o.cost;
		}
		
	}

	public static int solution(int[][] board) {
		int N = board.length;
		int[][][] visited = new int[4][N][N]; // 4방향에 대한 dp가 모두 필요하다
		int answer = 0;
		int[] dy = { 1, 0, -1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		
		PriorityQueue<Node> pq = new PriorityQueue<>();// 우선순위 큐를 사용해 비용이 작은 순 -> y이가 큰순 -> x가 큰순으로 출력
      
		pq.offer(new Node(0, 0, -1, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(node.y == N-1 && node.x == N-1) { // 가장 오른쪽 아래를 방문할경우 탐색을 멈춘다
				answer = node.cost;
				break;
			}
            
			
			for(int i = 0; i < 4; i++) { // 4방향을 탐색한다
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				int nd = i;
				int ncost = node.cost;
				
				if(node.d == -1) { // 처음 시작할 때는 모든 방향에 대해서 직선 경주로를 건설 할 수 있다
					ncost += 100;
				} else {
					ncost += node.d == nd ? 100 : 600; // 코너를 돌때는 직선도로 하나와 코너 하나가 필요한다
				}
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= N || board[ny][nx] == 1) continue; // 범위를 벗어나거나 벽일때는 다른 방향을 탐색한다
                if(visited[ny][nx][nd] != 0 && visited[ny][nx][nd] < ncost) continue; // 이 방향으로 더 적은 비용을 통해 올 수 있었다면 더이상 탐색을 진행하지 않는다.
                
				visited[ny][nx][nd] = ncost; // 방문 표시
				pq.offer(new Node(ny, nx, nd, ncost)); // 우선순위 큐에 다음 노드와 비용을 넣는다
			}
		}

		return answer;
	}
}
