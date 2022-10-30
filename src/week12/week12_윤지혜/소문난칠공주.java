package week12.week12_윤지혜;

import java.util.*;
import java.io.*;

public class 소문난칠공주 {

	static char[][] arr;
	static int[] nums;
	static Queue<int[]> q;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];
		for(int i = 0; i < 5; i++) {
			String line = br.readLine();
			for(int j = 0; j < 5; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		nums = new int[7];
		Comb(0, 0);
		
		System.out.println(answer);
	}
	
	private static void Comb(int cnt, int start) {
		if(cnt == 7) {
			if(BFS()) answer++;
			return;
		}
		
		for(int i = start; i < 25; i++) {
			nums[cnt] = i;
			Comb(cnt+1, i+1);
		}
	}

	private static boolean BFS() {
		int Cnt = 0;
		int Ycnt = 0;
        q = new ArrayDeque<>();
		visited = new boolean[5][5];	// 배열 방문처리
		int n = nums[0];	// 생성된 조합의 첫번째 값 꺼내기
		// 첫번째 값을 x,y(배열 형태)로 바꾸기
		int x = n/5;
		int y = n%5;
		
		// 첫번째 값 큐에 넣고 배열, 조합 방문처리
		q.offer(new int[] {x,y});
		visited[x][y] = true;
		if(arr[x][y] == 'Y') Ycnt++;	// 해당 값이 Y면 카운트해준다
		Cnt++;	// 전체 Cnt 올려주기
		
		while(!q.isEmpty()) {
			if(Cnt == 7) return true;	// 조합에 있는 7개 숫자가 모두 가능한 경우면 종료
			
			int[] temp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = temp[0]+dr[d];
				int nc = temp[1]+dc[d];
				
				if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;
				
				int idx = isInComb(nr, nc);	// 조합 안에 있는 숫자인지 확인
				if(!visited[nr][nc] && idx != -999) {	// 배열 내에서 방문 x고, 조합 내에도 있는 값이면
					if(arr[nr][nc] == 'Y') Ycnt++;	// 해당 값이 Y면 카운트해준다
					
					if(Ycnt < 4) {	// Y가 4명 미만일 경우에만 가능
						q.offer(new int[] {nr,nc});	// 큐에 넣고
						visited[nr][nc] = true;	// 배열 방문체크
						Cnt++;	// 전체 Cnt 올려주기
					}else continue;	// Y가 4명 이상일 경우 백트래킹 (불가능한 경우)
					
				}
			}
		}
		return false;
	}

	private static int isInComb(int x, int y) {
		int n = x * 5 + y;	// 배열 형태를 다시 숫자로 바꿔주기
		
		for(int i = 1; i < 7; i++) {	// 조합을 다 뒤진다
			if(nums[i] == n) {	// 조합 안에 있는 값이면
				return i;	// 조합 안에서의 인덱스 값을 준다
			}
		}
		// 조합 안에 없는 값이면 -999를 준다
		return -999;
	}

}
