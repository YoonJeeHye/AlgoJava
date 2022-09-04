import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 동전0 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		int[] nk=Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n=nk[0];
		int k=nk[1];
		int cnt=0;
		
		Stack<Integer> stack=new Stack<>();
		
		for(int i=0;i<n;i++) {
			stack.add(Integer.parseInt(bufferedReader.readLine()));
		}
		
		while(!stack.isEmpty() || k>0) {
			int coin=stack.pop();
			if(k/coin>0) {
				cnt+=k/coin;
				k=k%coin;
			}
		}
		
		System.out.println(cnt);
	}

}
