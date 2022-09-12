package week6.week6_양주연;

import java.io.*;
import java.util.*;
public class 인구이동
{
    static int N, L, R, sum;
    static boolean[][] chk;
    static ArrayList<Coor> list;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] A;
    static class Coor{
        int x, y;
        public Coor(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void dfs(int x, int y){
        sum+=A[x][y];
        list.add(new Coor(x, y));
        chk[x][y]=true;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<N && !chk[nx][ny]){
                int dif = Math.abs(A[x][y]-A[nx][ny]);
                if(dif>=L && dif<=R){
                    dfs(nx, ny);
                }
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		L = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);
		A = new int[N][N];
		for(int i=0; i<N; i++){
		   input = br.readLine().split(" ");
		   for(int j=0; j<N; j++){
		       A[i][j] = Integer.parseInt(input[j]);
		   }
		}
		int cnt = -1;
		while(true){
		    boolean moved = false;
		    cnt++;
		    chk = new boolean[N][N];
		    for(int i=0; i<N; i++){
		        for(int j=0; j<N; j++){
		            if(!chk[i][j]){
		                list = new ArrayList<>();
		                sum = 0;
		                dfs(i, j);
		                int len = list.size();
		                if(len==1) continue;
		                else{
		                    moved = true;
		                    for(Coor c : list){
    		                    A[c.x][c.y] = sum/len;
    		                }
		                }
		            }
		        }
		    }
		    if(!moved) break;
		}
		bw.write(cnt+"\n");
		br.close();
	    bw.flush();
	    bw.close();
	}
}