package week9.week9_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

class A046_BJ3187_양치기꿍 {
	static int R, C; 
	static int K, V; // 양의 수, 늑대의 수
	static class Pos {
		int x, y;

		public Pos(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(char[][] map, boolean[][] visited, int y, int x) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(y, x));
		visited[y][x] = true;
		int v = 0;
		int k = 0;
		
		while(!queue.isEmpty()) { // 큐가 빌때 까지 계속한다
			Pos p = queue.poll();
			y = p.y;
			x = p.x;
			
			if(map[y][x] == 'v') { // 늑대의 수를 더해준다
				v++;
			} else if(map[y][x] == 'k') { // 양의 수를 더해준다
				k++;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				// 범위를 벗어나거나 벽이거나 방문한 적이 있다면 탐색을 계속한다
				if(ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == '#' || visited[ny][nx]) continue;
				
				visited[ny][nx] = true;
				queue.add(new Pos(ny, nx));
			}
		}
		
		if(v < k) { // 양이 늑대를 잡아먹는다
			K += k;
		} else { // 늑대가 양을 잡아먹는다
			V += v;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		R = Integer.parseInt(inputs[0]);
		C = Integer.parseInt(inputs[1]);
		
		char[][] map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		K = 0;
		V = 0;
		
		for(int i = 0; i < R; i++) { // map을 저장한다
			String inputs2 = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = inputs2.charAt(j);
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != '#' && !visited[i][j]) { // 벽이 아니고 방문한 적이 없다면 BFS 탐색을 시작한다.
					bfs(map, visited, i, j);
				}
			}
		}
		
		bw.write(K + " " + V);
		br.close();
		bw.close();
	}
}
