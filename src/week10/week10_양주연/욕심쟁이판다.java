package week10.week10_양주연;

import java.io.*;
import java.util.*;
public class 욕심쟁이판다
{
    static int n;
    static int[] dx={1, 0, -1, 0}, dy={0, 1, 0, -1};
    static int[][] map, dp;
    static int dfs(int x, int y){
        if(dp[x][y]!=0) return dp[x][y];
        dp[x][y]=1;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && map[x][y]>map[nx][ny]){
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny)+1);
            }
        }
        return dp[x][y];
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		for(int i=0; i<n; i++){
		    String[] input = br.readLine().split(" ");
		    for(int j=0; j<n; j++){
		        map[i][j] = Integer.parseInt(input[j]);
		    }
		}
		int max=0;
		for(int i=0; i<n; i++){
		    for(int j=0; j<n; j++){
		        dp[i][j] = dfs(i, j); //어떤 좌표에서 출발하여 해당 좌표(i, j)에 도착한다고 할 때 판다가 이동할 수 있는 칸 수의 최댓값
		        if(max < dp[i][j]) max = dp[i][j];
		    }
		}
		bw.write(max+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}