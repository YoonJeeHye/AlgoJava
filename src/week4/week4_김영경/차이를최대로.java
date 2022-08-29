import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;

public class 차이를최대로 {
	
	static int max=Integer.MIN_VALUE;
	static int[] arr;
	static int n;
	
	static public void dfs(int level,boolean[] visited,int[] list) {
		if(level==n) {
			int tmp=0;
			for(int i=0;i<n-1;i++)
				tmp+=Math.abs(list[i]-list[i+1]);
			//System.out.println(Arrays.toString(list));
			max=Math.max(max, tmp);
		}
		else {
			for(int i=0;i<n;i++) {
				if(visited[i])
					continue;
				else {
					visited[i]=true;
					list[level]=arr[i];
					dfs(level+1, visited, list);
					visited[i]=false;
				}
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(bufferedReader.readLine());
		arr=Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		
		dfs(0, new boolean[n], new int[n]);
		
		System.out.println(max);
	}

}
