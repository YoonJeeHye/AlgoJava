import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 추월 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bufferedReader.readLine());
		HashMap<String, Integer> seq=new HashMap<>();
		for(int i=0;i<n;i++) {
			seq.put(bufferedReader.readLine(), i);
		}
		boolean[] visited=new boolean[n];
		int cnt=0;
		for(int i=0;i<n;i++) {
			int a=seq.get(bufferedReader.readLine());
			for(int j=0;j<a;j++)if(!visited[j]) {
				cnt++;
				break;
			}
			visited[a]=true;
		}
		System.out.println(cnt);
	}
}
