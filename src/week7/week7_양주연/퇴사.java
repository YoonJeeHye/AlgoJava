package week7.week7_양주연;

import java.io.*;
public class 퇴사
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[n+2]; //해당 일에 잡힌 상담을 완료하는데 걸리는 기간
		int[] p = new int[n+2]; //해당 일에 잡힌 상담을 했을 때 받을 수 있는 금액
		int[] dp = new int[n+2]; //dp[i] -> 상담 가능 기간이 i일부터 n일까지라고 할 때 받을 수 있는 최대 금액
		for(int i=1; i<=n; i++){
		    String[] input = br.readLine().split(" ");
		    t[i] = Integer.parseInt(input[0]);
		    p[i] = Integer.parseInt(input[1]);
		}
		for(int i=n; i>0; i--){
		    if(i+t[i]<=n+1){ //i일에 잡혀있는 상담 진행 가능한 경우
		        dp[i] = Math.max(p[i]+dp[i+t[i]], dp[i+1]);
		    }
		    else{ //기간 벗어나서 i일에 잡혀있는 상담 진행 불가능한 경우
		        dp[i] = dp[i+1]; 
		    }
		}
		bw.write(dp[1]+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}