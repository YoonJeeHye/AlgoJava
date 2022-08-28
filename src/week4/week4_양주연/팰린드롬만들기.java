package week4.week4_양주연;

import java.io.*;
import java.util.*;

public class 팰린드롬만들기
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int[] alpCnt = new int[26];
		for(char c : s.toCharArray()){
		    alpCnt[c-65]++;
		}
		int oddNumCnt=0, oddNumIdx=-1;
		for(int i=0; i<alpCnt.length; i++){
		    if(alpCnt[i]%2==1){
		        oddNumCnt++;
		        oddNumIdx=i;
		    }
		}
		if(oddNumCnt>1){
		    bw.write("I'm Sorry Hansoo");
		}
		else{
		    StringBuilder sb = new StringBuilder();
		    for(int i=0; i<alpCnt.length; i++){
		        if(alpCnt[i]>0){
		            for(int j=0; j<alpCnt[i]/2; j++){
		                sb.append((char)(i+65));
		            }
		        }
		    }
		    StringBuilder answer = new StringBuilder();
		    answer.append(sb);
		    if(oddNumCnt==1){
		        answer.append((char)(oddNumIdx+65));
		    }
		    answer.append(sb.reverse());
		    bw.write(answer.toString());
		}
		br.close();
		bw.flush();
		bw.close();
	}
}