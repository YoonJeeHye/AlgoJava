package week11.week11_윤지혜;

import java.io.*;
import java.util.*;

public class 봄버맨 {
	
	static int R, C, N;
	static char[][] arr;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		N = Integer.parseInt(line[2]);
		
		arr = new char[R][C];
		q = new ArrayDeque<>();
		for(int r = 0; r < R; r++) {
			String line2 = br.readLine();
			for(int c = 0; c < C; c++) {
				arr[r][c] = line2.charAt(c);
			}
		}
		
		if(N == 1) {
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					System.out.print(arr[r][c]);
				}
				System.out.println();
			}
		}
		else {
			// 짝수초 후에는 모든 폭탄이 차있다
			if(N % 2 == 0) {
				for(int r = 0; r < R; r++) {
					for(int c = 0; c < C; c++) {
						System.out.print('O');
					}
					System.out.println();
				}
			}else {	// 홀수초 후에는 BFS를 돌려본다
				int cnt = 1;
				while(cnt != N) {
					visited = new boolean[R][C];
					for(int r = 0; r < R; r++) {
						for(int c = 0; c < C; c++) {
							if(!visited[r][c] && arr[r][c] == 'O') {
								visited[r][c] = true;
								q.offer(new int[] {r,c});
							}
						}
					}
					BFS();
					
					// 폭탄과 평지를 바꿔준다
					for(int r = 0; r < R; r++) {
						for(int c = 0; c < C; c++) {
							if(arr[r][c] == '.') arr[r][c] = 'O';
							else if(arr[r][c] == 'O') arr[r][c] = '.';
						}
					}
					
					cnt += 2;	// 몇 번 수행되었는지 계산
				}
				// 출력
				for(int r = 0; r < R; r++) {
					for(int c = 0; c < C; c++) {
						System.out.print(arr[r][c]);
					}
					System.out.println();
				}
				
			}
		}
		
	}
	
	private static void BFS() {
	
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				
				if(!visited[nr][nc] && arr[nr][nc] == '.') {
					visited[nr][nc] = true;
					arr[nr][nc] = 'O';
				}
			}
		}
	}
	
	
	
}
