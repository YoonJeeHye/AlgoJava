package week7.week7_양주연;

import java.io.*;
public class 빙고
{
    static int[][] board;
    static boolean isBingo = false;
    static void eraseNum(int num){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(board[i][j]==num){
                    board[i][j]=0;
                    return;
                }
            }
        }
    }
    static void chkBingo(){
        int zeroCnt, bingoCnt=0;
        //대각선 체크
        zeroCnt=0;
        for(int i=0; i<5; i++){
            if(board[i][i]==0) zeroCnt++;
            else break;
        }
        if(zeroCnt==5) bingoCnt++;
        zeroCnt=0;
        for(int i=0; i<5; i++){
            if(board[i][4-i]==0) zeroCnt++;
            else break;
        }
        if(zeroCnt==5) bingoCnt++;
        //가로 체크
        for(int i=0; i<5; i++){
            zeroCnt=0;
            for(int j=0; j<5; j++){
                if(board[i][j]==0) zeroCnt++;
                else break;
            }
            if(zeroCnt==5) bingoCnt++;
        }
        if(bingoCnt>=3){
            isBingo = true;
            return;
        }
        //세로 체크
        for(int j=0; j<5; j++){
            zeroCnt=0;
            for(int i=0; i<5; i++){
                if(board[i][j]==0) zeroCnt++;
                else break;
            }
            if(zeroCnt==5) bingoCnt++;
        }
        if(bingoCnt>=3){
            isBingo = true;
            return;
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		board = new int[5][5];
		for(int i=0; i<5; i++){
		    String[] input = br.readLine().split(" ");
		    for(int j=0; j<5; j++){
		        board[i][j] = Integer.parseInt(input[j]);
		    }
		}
		int cnt=0;
		for(int i=0; i<5; i++){
		    String[] input = br.readLine().split(" ");
		    for(int j=0; j<5; j++){
		        cnt++;
		        int num = Integer.parseInt(input[j]);
		        eraseNum(num);
		        if(cnt>=12){
		            chkBingo();
		            if(isBingo) break;
		        }
		    }
		    if(isBingo) break;
		}
		bw.write(cnt+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}