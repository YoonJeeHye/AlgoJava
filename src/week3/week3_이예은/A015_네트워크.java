package week3.week3_이예은;

class A015_네트워크 {
	boolean[] visited;

	public void DFS(int node, int[][] computers, int n) { // 재귀 DFS를 통해 하나의 네트워크로 연결된 모든 노드를 방문한다
		visited[node] = true;

		for (int i = 0; i < n; i++) {
			if (i == node) // 자기 자신에서 시작해서 자기 자신으로 돌아오지 않는다
				continue;
			if (!visited[i] && computers[node][i] == 1) // 방문한 적이 없고, 현재노드와 연결되어 있다면 방문한다
				DFS(i, computers, n);
		}
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n];

		for (int i = 0; i < n; i++) { // 모든 노드들을 탐색한다
			if (!visited[i]) {
				DFS(i, computers, n); // 하나의 네트워크를 방문
				answer += 1;
			}
		}
		return answer;
	}
}
