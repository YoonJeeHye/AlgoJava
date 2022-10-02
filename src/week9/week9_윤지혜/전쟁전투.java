package week9.week9_윤지혜;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 전쟁전투 {

	static int N, M;
	static char[][] arr;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int Wcnt, Bcnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		
		arr = new char[M][N];
		visited = new boolean[M][N];
		for(int m = 0; m < M; m++) {
			String line2 = br.readLine();
			for(int n = 0; n < N; n++) {
				arr[m][n] = line2.charAt(n);
			}
		}
		
		int Wsum = 0;
		int Bsum = 0;
		q = new ArrayDeque<>();
		for(int m = 0; m < M; m++) {
			for(int n = 0; n < N; n++) {
				if(!visited[m][n] && arr[m][n] == 'W') {
					WBFS(m, n);
					Wsum += Math.pow(Wcnt, 2);
				}
					
				else if(!visited[m][n] && arr[m][n] == 'B') {
					BBFS(m, n);
					Bsum += Math.pow(Bcnt, 2);
				}
					
			}
		}
		System.out.println(Wsum + " " + Bsum);
		
	}
	private static void BBFS(int m, int n) {
		q.offer(new int[] {m, n});
		visited[m][n] = true;
		Bcnt = 1;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
				if(visited[nr][nc] || arr[nr][nc] == 'W') continue;
				
				if(!visited[nr][nc] && arr[nr][nc] == 'B') {
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					Bcnt++;
				}
			}
			
		}
		
	}
	
	private static void WBFS(int m, int n) {
		q.offer(new int[] {m, n});
		visited[m][n] = true;
		Wcnt = 1;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
				if(visited[nr][nc] || arr[nr][nc] == 'B') continue;
				
				if(!visited[nr][nc] && arr[nr][nc] == 'W') {
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					Wcnt++;
				}
			}
			
		}
	}
}
