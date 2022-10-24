package week11.week11_양주연;

import java.io.*;
import java.util.*;
public class 봄버맨
{
    static int R, C, N;
    static int[] dx={-1, 0, 1, 0}, dy={0, 1, 0, -1};
    private static char[][] afterBomb(char[][] prev){
        char[][] res = new char[R][C];
        for(int i=0; i<R; i++){
            Arrays.fill(res[i], 'O');
        }
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(prev[i][j]=='O'){
                    res[i][j]='.';
                    for(int k=0; k<4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx>=0 && nx<R && ny>=0 && ny<C){
                            res[nx][ny]='.';
                        }
                    }
                }
            }
        }
        return res;
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]); //행
		C = Integer.parseInt(input[1]); //열
		N = Integer.parseInt(input[2]); //N초
		char[][][] board = new char[N+1][R][C]; //board[i] -> i초일 떄의 board 상태인 이차원 배열.
		for(int i=0; i<R; i++){
		    String line = br.readLine();
		    for(int j=0; j<C; j++){
		        board[1][i][j] = line.charAt(j);
		    }
		}
		if(N==1){
		    for(int i=0; i<R; i++){
		        for(int j=0; j<C; j++){
		            bw.write(board[1][i][j]+"");
		        }
		        bw.write("\n");
		    }
		}
		else if(N%2==0){
		    for(int i=0; i<R; i++){
		        for(int j=0; j<C; j++){
		            bw.write("O");
		        }
		        bw.write("\n");
		    }
		}
		else{
		    for(int i=3; i<=N; i+=2){
		        board[i] = afterBomb(board[i-2]);
		    }
		    for(int i=0; i<R; i++){
		        for(int j=0; j<C; j++){
		            bw.write(board[N][i][j]+"");
		        }
		        bw.write("\n");
		    }
		}
		br.close();
		bw.flush();
		bw.close();
	}
}