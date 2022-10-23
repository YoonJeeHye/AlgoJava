package week10.week10_윤지혜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class 양치기꿍{

	static int R, C;
	static char[][] arr;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int WOLF, SHEEP;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		
		arr = new char[R][C];
		for(int r = 0; r < R; r++) {
			String line2 = br.readLine();
			for(int c = 0; c < C; c++) {
				arr[r][c] = line2.charAt(c);
			}
		}
		
		visited = new boolean[R][C];
		q = new ArrayDeque<>();
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(!visited[r][c] && arr[r][c] != '#') {
					q.offer(new int[] {r,c});
					visited[r][c] = true;
					calc(); // 울타리 안의 양, 늑대 찾는 BFS
				}
			}
		}
		
		System.out.print(SHEEP + " " + WOLF);
	}
	private static void calc() {
		
		int wolf = 0;
		int sheep = 0;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			if(arr[temp[0]][temp[1]] == 'v') wolf++;
			else if(arr[temp[0]][temp[1]] == 'k') sheep++;
			
			for(int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				
				if(!visited[nr][nc] && arr[nr][nc] != '#') {
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		
		if(wolf < sheep) SHEEP += sheep;
		else WOLF += wolf;
		
	}
	
}
