package week3_이예은;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    // BFS와 큐를 활용해서 풀수 있다
    public int A011_가장먼노드(int n, int[][] edge) {
        int answer = 0;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 
        // 인접리스트 형태로 저장

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>()); // 인접리스트 초기화
		}

		for (int i = 0; i < edge.length; i++) {
			int n1 = edge[i][0];
			int n2 = edge[i][1];

			graph.get(n1).add(n2);// 양방향으로
			graph.get(n2).add(n1);
		}

        // 같은 거리의 노드를 방문해야하기 때문에 Queue를 사용해 BFS로 푼다
		Queue<Integer> queue = new LinkedList<>(); 
		boolean[] visited = new boolean[n + 1];
		queue.offer(1); // 처음 1번 노드를 방문한다
		visited[1] = true;

		while (true) {
			answer = queue.size(); // 큐의 길이 = 같은 거리의 노드들의 개수
			Queue<Integer> queue2 = new LinkedList<>(); // 같은 거리의 노드를 담을 큐
			while (!queue.isEmpty()) {

				int node = queue.poll();

				for (int next : graph.get(node)) {
					if (visited[next]) continue;// 노드를 방문한 적이 있다면 방문하지 않는다
					queue2.offer(next);
					visited[next] = true;
				}
			}
			queue = queue2; 
            // 이전 큐가 다 비었다면 다음 같은 거리의 노드들이 저장된 큐로 갱신한다
			
			if(queue.isEmpty()) break; // 큐가 비었다면 무한루프를 빠져나온다
		}
		return answer;
    }
}