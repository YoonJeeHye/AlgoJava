import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bufferedReader.readLine());
		
		long[] dp=new long[n+1];
		long[] zeros=new long[n+1];
		
		dp[0]=0;
		zeros[0]=0;
		dp[1]=1;
		zeros[1]=0;
		for(int i=2;i<=n;i++) {
			zeros[i]=dp[i-1];
			dp[i]=dp[i-1]+zeros[i-1];
		}
		
		System.out.println(dp[n]);
	}

}
