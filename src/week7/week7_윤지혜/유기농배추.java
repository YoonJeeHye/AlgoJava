package week7.week7_윤지혜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

package 윤지혜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 유기농배추{

	static int M, N;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<int[]> q;
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			String[] line = br.readLine().split(" ");
			M = Integer.parseInt(line[0]);
			N = Integer.parseInt(line[1]);
			int K = Integer.parseInt(line[2]);
			
			arr = new int[M][N];
			visited = new boolean[M][N];
			// 배추 위치 1로 만들어주기
			for(int k = 0; k < K; k++) {
				line = br.readLine().split(" ");
				arr[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = 1;
			}
			
			
			q = new ArrayDeque<>();
			int answer = 0;
			for(int m = 0; m < M; m++) {
				for(int n = 0; n < N; n++) {
					if(arr[m][n] == 1 && !visited[m][n]) {
						q.add(new int[] {m,n});
						visited[m][n] = true;
						BFS();
						answer++;
					}
				}
			}
			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}
	
	
	private static void BFS() {
		
		while(!q.isEmpty()) {
			int temp[] = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				if(nr < 0 || nr >= M || nc < 0 || nc >= N || arr[nr][nc] == 0) continue;
				
				if(arr[nr][nc] == 1 && !visited[nr][nc]) {
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
				
				
			}
		}
		
	}
}

