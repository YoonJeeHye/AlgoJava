package week5.week5_양주연;

import java.io.*;
public class 이친수
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int N = Integer.parseInt(br.readLine());
	    long[] dp = new long[N+1];
	    dp[0]=0;
	    for(int i=1; i<=N; i++){
	        if(i==1) dp[i] = 1;
	        else{
	            dp[i] = dp[i-2]+dp[i-1];
	        }
	    }
	    bw.write(dp[N]+"\n");
	    br.close();
	    bw.flush();
	    bw.close();
	}
}