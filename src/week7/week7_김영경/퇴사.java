import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 퇴사 {

	static tp[] list;
	static int n;
	static int max=0;

	public static void dfs(int level,int sum) {
		if(level>n)return;
		if(sum>max) {
			max=sum;
			System.out.println(level + " "+sum);
		}
		for(int i=level;i<n;i++) {
			dfs(i+list[i].t, sum+list[i].p);
		}
	}

	public static class tp {
		int t;
		int p;

		tp(int t, int p) {
			this.t = t;
			this.p = p;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bufferedReader.readLine());
		list = new tp[n];
		for (int i = 0; i < n; i++) {
			int[] tmp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			list[i]=new tp(tmp[0],tmp[1]);
		}
		dfs(0, 0);
		
		System.out.println(max);
	}

}
