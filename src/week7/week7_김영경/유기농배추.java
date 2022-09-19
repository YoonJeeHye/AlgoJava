import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 유기농배추 {

	public static int[] parent;

	public static int find(int node) {
		if (parent[node] < 0)
			return node;
		else return parent[node] = find(parent[node]);
	}

	public static void union(int v1, int v2) {
		int a = find(v1);
		int b = find(v2);
		if (a != b) {
			if (parent[a]==parent[b]) {
				parent[b] = a;
				parent[a]--;
			} else if (parent[a] > parent[b]) {
				parent[a]=b;
			}else if(parent[a] < parent[b]) {
				parent[b]=a;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufferedReader.readLine());
		for (int q = 0; q < t; q++) {
			int[] mnk = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int m=mnk[0];
			int n=mnk[1];
			int[][] map=new int[m][n];
			parent = new int[m*n];
			Arrays.fill(parent, -1);
			for(int i=0;i<mnk[2];i++) {
				int[] xy = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int x=xy[0];
				int y=xy[1];
				map[x][y]=1;
				if(x-1>=0 && map[x-1][y]==1) {
					union((x-1)*n+y,x*n+y);
				}
				if(x+1<m && map[x+1][y]==1) {
					union((x+1)*n+y,x*n+y);
				}
				if(y-1>=0 && map[x][y-1]==1) {
					union(x*n+y-1,x*n+y);
				}
				if(y+1<n && map[x][y+1]==1) {
					union(x*n+y+1,x*n+y);
				}
			}
			int cnt=0;
			for(int i=0;i<m*n;i++) {
				if(map[i/n][i%n]==1 && parent[i]<0)
					cnt++;
			}
			System.out.println(cnt);
		}

	}

}
