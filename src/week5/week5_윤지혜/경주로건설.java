package week5.week5_윤지혜;

import java.util.*;

// 테케25 실패
public class 경주로건설{
	
	// 1. BFS
	// 	사방탐색
	// 		for문 넘어가는 곳이 코너
	
	// 4방 탐색(상 하 좌 우)
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int N;
	static Queue<int[]> q;
	static boolean visited[][];

	static int min = Integer.MAX_VALUE;
	public static int solution(int[][] board) {
        int answer = 0;
		
        N = board.length;
        q = new ArrayDeque<>();
        visited = new boolean[N][N];
        BFS(board);
        
        answer = min;
        return answer;
    }

	private static void BFS(int[][] board) {
		q.offer(new int[] {0,0,-1,0});	// x, y, 방향, 가격
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int d = temp[2];
			int p = temp[3];

			if(temp[0] == N-1 && temp[1] == N-1) {
				min = Math.min(min, p);
			}
			
			for(int i = 0; i < 4; i++) {
				
				int nr = temp[0]+dr[i];
				int nc = temp[1]+dc[i];
				int nd = i;
				int np = temp[3];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == 1) continue;
				
				if(d == -1) np += 100;	// 처음
				else if(d == nd) np += 100;	// 방향 같을 때
				else np += 600;	// 방향 바뀔 때
				
				if(!visited[nr][nc] || board[nr][nc] >= np) {	// 최소 가격 넣어주기
					board[nr][nc] = np;
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,nd,np});
				}
				
			}
		}
	}

	public static void main(String[] args) {
		int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
		System.out.println(solution(board));
	}
}
