package week4.week4_양주연;

import java.io.*;
public class 뒤집기
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String S = br.readLine();
		int zeroSeqCnt=0, oneSeqCnt=0;
		boolean zeroSeqStarted = false, oneSeqStarted = false;
		for(char c : S.toCharArray()){
		    if(c=='0'){
		        oneSeqStarted=false;
		        if(!zeroSeqStarted){
		            zeroSeqStarted = true;
		            zeroSeqCnt++;
		        }
		    }
		    else{
		        zeroSeqStarted=false;
		        if(!oneSeqStarted){
		            oneSeqStarted = true;
		            oneSeqCnt++;
		        }
		    }
		}
		bw.write(Math.min(zeroSeqCnt, oneSeqCnt)+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}