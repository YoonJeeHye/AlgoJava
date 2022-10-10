package week9.week9_양주연;

import java.io.*;
import java.util.*;
public class 주식
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
		    int N = Integer.parseInt(br.readLine());
		    int[] stock = new int[N];
		    String[] input = br.readLine().split(" ");
		    for(int i=0; i<N; i++){
		        stock[i] = Integer.parseInt(input[i]);
		    }
		    int max=0;
		    long profit=0;
		    for(int i=N-1; i>=0; i--){
		        if(stock[i]>=max) max=stock[i];
		        else profit+=max-stock[i];
		    }
		    bw.write(profit+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}