package week7.week7_양주연;

import java.io.*;
public class 유기농배추
{
    static int M, N;
    static int[][] field;
    static int[] dx={-1, 0, 1, 0}, dy={0, 1, 0, -1};
    static void dfs(int x, int y){
        field[x][y]=0; //방문했으므로 해당 위치 0으로 바꿈
        for(int i=0; i<4; i++){ //상, 우, 하, 좌
            int nx = x+dx[i]; // 새 행 좌표
            int ny = y+dy[i]; // 새 열 좌표
            if(nx>=0 && nx<N && ny>=0 && ny<M && field[nx][ny]==1){ // 새 좌표가 배추밭 범위 안이고 값이 1이면(배추가 심어져 있으면)
                dfs(nx, ny); //새 좌표로 dfs
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()); //테스트 케이스
		for(int tc=1; tc<=T; tc++){ //테스트 케이스 수만큼 반복
		    String[] input = br.readLine().split(" ");
		    M = Integer.parseInt(input[0]); //배추 밭 열 개수
		    N = Integer.parseInt(input[1]); //배추 밭 행 개수
		    int K = Integer.parseInt(input[2]);
		    field = new int[N][M]; //배추밭
		    for(int i=0; i<K; i++){
		        input = br.readLine().split(" ");
		        int X = Integer.parseInt(input[0]);
		        int Y = Integer.parseInt(input[1]);
		        field[Y][X] = 1; //배추의 위치에 1 저장
		    }
		    int cnt=0; //배추흰지렁이 마리 수
		    for(int i=0; i<N; i++){
		        for(int j=0; j<M; j++){
		            if(field[i][j]==1){ //해당 위치 1이면
		                dfs(i, j); //dfs
		                cnt++; //배추흰지렁이 마리 수 +1
		            }
		        }
		    }
		    bw.write(cnt+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}