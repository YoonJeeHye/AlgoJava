package week8.week8_윤지혜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지구온난화 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int R = Integer.parseInt(line[0]);
		int C = Integer.parseInt(line[1]);
		
		// 원본
		char arr[][] = new char[R][C];
		int totalXcnt = 0;
		for(int r = 0; r < R; r++) {
			line = br.readLine().split("");
			for(int c = 0; c < C; c++) {
				arr[r][c] = line[c].charAt(0);
				if(arr[r][c] == 'X') totalXcnt++;
			}
		}
		
		// 복사본
		char c_arr[][] = new char[R][C];
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				c_arr[r][c] = arr[r][c];
			}
		}
		
		int dr[] = {-1,1,0,0};
		int dc[] = {0,0,-1,1};
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(c_arr[r][c] == 'X') {
					int Xcnt = 0;
					for(int d = 0; d < 4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						
						if(nr < 0 || nc < 0 || nr >= R || nc >= C || c_arr[nr][nc] == '.') continue;
						if(c_arr[nr][nc] == 'X') Xcnt++;
					}
					if(Xcnt <= 1) {
						arr[r][c] = '.';
						totalXcnt--;
					}
				}
			}
		}
		

		if(totalXcnt <= 0) System.out.println("X");
		else {
			// 범위 잡기
			int rmax = Integer.MIN_VALUE;
			int cmax = Integer.MIN_VALUE;
			int rmin = Integer.MAX_VALUE;
			int cmin = Integer.MAX_VALUE;
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(arr[r][c] == 'X') {
						rmax = Math.max(rmax, r);
						rmin = Math.min(rmin, r);
						cmax = Math.max(cmax, c);
						cmin = Math.min(cmin, c);
					}
				}
			}
			
			// 출력
			for(int r = rmin; r <= rmax; r++) {
				for(int c = cmin; c <= cmax; c++) {
					System.out.print(arr[r][c]);
				}
				System.out.println();
			}
		}

	}

}

