package week5.week5_양주연;

import java.io.*;
public class 포도주시식
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int n = Integer.parseInt(br.readLine()); //포도주 잔의 개수 n
	    int[] wine = new int[n+1]; //포도주 잔에 들어있는 포도주의 양(1~n)
	    int[] dp = new int[n+1]; //dp[i] = 1번째 포도주 잔부터 i번째 포도주 잔까지 있다고 했을 때 최대로 마실 수 있는 포도주의 양
	    for(int i=1; i<=n; i++){
	        wine[i] = Integer.parseInt(br.readLine()); //잔에 들어있는 포도주의 양 입력받음
	    }
	    for(int i=1; i<=n; i++){
	        if(i==1){ //1번째 포도주 잔만 있을 경우
	            dp[i] = wine[i]; //1번째 포도주 잔 마시는 경우가 최대로 마실 수 있는 포도주의 양
	        }
	        else if(i==2){ //2번째 포도주 잔까지 있을 경우
	            dp[i] = wine[i-1]+wine[i]; //1번째 포도주 잔과 2번재 포도주 잔 모두 마시는 경우가 최대로 마실 수 있는 포도주의 양
	        }
	        else{ //i번째 포도주 잔까지 있을 경우 (i>=3)
	            //3개의 포도주를 연속으로 마실 수 없음.
	            //i번째(현재) 포도주 잔을 마시는 경우는, i-1번째(이전) 포도주 잔을 마시는 경우와 마시지 않는 경우로 나뉨.
	            //i-1번째(이전) 포도주 잔을 마시는 경우는, i-2번째 포도주 잔은 마시지 않아야 하며, i-3번째 포도주 잔부터는 i번째(현재) 포도주 잔 마시는 조건에 영향미치지 않으므로 그냥 저장된 max 가져옴
	            //=> dp[i-3]+wine[i-1]+wine[i]
	            //i-1번째(이전) 포도주 잔을 마시지 않는 경우는, i-2번째 포도주 잔부터는 i번째(현재) 포도주 잔 마시는 조건에 영향미치지 않으므로 그냥 저장된 max 가져옴
	            //=> dp[i-2]+wine[i]
	            dp[i] = Math.max(dp[i-2]+wine[i], dp[i-3]+wine[i-1]+wine[i]); //i번째 포도주 잔까지 있다고 할 때, i번째(현재) 포도주 잔을 꼭 마시면서 최대로 마실 수 있는 포도주의 양
	            dp[i] = Math.max(dp[i-1], dp[i]); //마지막 번째(i번째)인 포도주 잔을 꼭 마셔야 한다는 조건이 없으므로, i-1번째(이전) 포도주 잔까지 있다고 할 때 마실 수 있는 최대값과 윗줄에서 구한 값을 비교해 둘 중 최댓값을 저장
	        }
	    }
	    bw.write(dp[n]+"\n"); //n번째 포도주 잔까지 있을 경우 최대로 마실 수 있는 포도주의 양을 출력
	    br.close();
	    bw.flush();
	    bw.close();
	}
}