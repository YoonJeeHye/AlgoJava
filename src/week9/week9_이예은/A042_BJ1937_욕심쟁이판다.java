package week9.week9_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class A042_BJ1937_욕심쟁이판다 {
	static int N;
	static int max;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	// dp[y][x] y, x에서 출발에서 가장 많이 이동할 수 있는 칸을 저장한다
	public static int dfs(int y, int x, int level) {
		
		if(dp[y][x] != 0) { // 값이 저장되어있다면 이전에 DFS탐색을 한것이기 때문에 더이상 탐색하지 않고 바로 리턴한다
			return dp[y][x];
		}
		
		int local_max = 0;
		for(int i = 0; i < 4; i++) { // 상하좌우를 탐색하면서 방문 할 수 있는 곳을 찾는다
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			// 범위가 넘어가거나 값이 작은 곳은 방문 할 수 없다
			if(ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] <= map[y][x]) continue;
			
			int temp = dfs(ny, nx, level+1); // 4방향중 갈 수 있는 곳에서 가장 큰 값을 찾는다
			local_max = local_max < temp? temp: local_max; // 전체 max 값을 갱신한다
		}
		dp[y][x] = local_max + 1; // dp에 값을 저장한다.
		max = dp[y][x] > max ? dp[y][x]: max; // 전체 max값을 갱신한다
		
		return dp[y][x];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		map = new int[N][N];
		dp = new int[N][N];
		
		for(int i = 0; i < N; i++) { // 대나무 숲의 정보를 저장한다
			String[] inputs = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
		/*-----------입력 끝----------*/

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(dp[i][j] == 0) { // dp테이블에 저장된 값이 0이 아니라는건 이전에 DFS탐색을 한것 이기 때문에 더이상 탐색하지 않는다
					dfs(i, j, 1);
				}
			}
		}
		
		//System.out.println(Arrays.deepToString(dp));
		/*-----------출력 시작----------*/
		bw.write(max + "");
		br.close();
		bw.close();
	}
}
