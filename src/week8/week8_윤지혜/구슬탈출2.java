package week8.week8_윤지혜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class 구슬탈출2 {

	static int rn, rm, bn, bm;
	static int answer;
	static int N, M;
	static char[][] arr;
	static boolean[][][][] visited;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		
		arr= new char[N][M];
		visited = new boolean[N][M][N][M];
		// R의 위치
		rn = 0;
		rm = 0;
		// B의 위치
		bn = 0;
		bm = 0;
		for(int n = 0; n < N; n++) {
			line = br.readLine().split("");
			for(int m = 0; m < M; m++) {
				arr[n][m] = line[m].charAt(0);
				if(arr[n][m] == 'R') {
					rn = n;
					rm = m;
				}
				if(arr[n][m] == 'B') {
					bn = n;
					bm = m;
				}
			}
		}
		
		q = new ArrayDeque<>();
		BFS();
		
		System.out.println(answer);
	}

	private static void BFS() {

		q.offer(new int[] {1, rn, rm, bn, bm});
		visited[rn][rm][bn][bm] = true;
		
		while(!q.isEmpty()) {

			int temp[] = q.poll();
			
			// 이동 10번 넘으면 -1 return
			if(temp[0] > 10) {
				answer = -1;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				// 방향 설정
				int nRr = temp[1];
				int nRc = temp[2];
				int nBr = temp[3];
				int nBc = temp[4];
				
				boolean isRhole = false;
				boolean isBhole = false;
				
				// 빨간 구슬 이동
				while(arr[nRr+dr[d]][nRc+dc[d]] != '#') {
					nRr += dr[d];
					nRc += dc[d];
					
					// 구멍 만났을 경우
					if(arr[nRr][nRc] == 'O') {
						isRhole = true;
						break;
					}
				}
				
				// 파란 구슬 이동
				while(arr[nBr+dr[d]][nBc+dc[d]] != '#') {
					nBr += dr[d];
					nBc += dc[d];
					
					// 구멍 만났을 경우
					if(arr[nBr][nBc] == 'O') {
						isBhole = true;
						break;
					}
				}
				
				// 파란 공이 구멍으로 들어가면 다른 방향 탐색
				if(isBhole) continue;
				
				// 빨간 구슬만 빠졌으면 성공
				if(isRhole && !isBhole) {
					answer = temp[0];
					return;
				}
				
				// 두 구슬이 같은 위치로 가는 경우
				if(nRr == nBr && nRc == nBc) {
					int redDis = Math.abs(nRr - temp[1])+Math.abs(nRc - temp[2]);
					int blueDis = Math.abs(nBr - temp[3]) + Math.abs(nBc - temp[4]);
					
					// 빨간 구슬이 온 거리가 더 길 경우 빨간 구슬 뒤로 이동
					if(redDis > blueDis) {
						nRr -= dr[d];
						nRc -= dc[d];
					}else {	// 파란 구슬이 온 거리가 더 길 경우 파란 구슬 뒤로 이동
						nBr -= dr[d];
						nBc -= dc[d];
					}
				}
				
				// 구슬들이 방문하지 않은 위치로만 가기
				if(!visited[nRr][nRc][nBr][nBc]) {
					visited[nRr][nRc][nBr][nBc] = true;
					q.offer(new int[] {temp[0]+1, nRr, nRc, nBr, nBc});
				}
			}
		}
		answer = -1;
	}

}
