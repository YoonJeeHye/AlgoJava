import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		int[] cnt=new int[2];
		
		char[] arr=bufferedReader.readLine().toCharArray();
		
		char prev=arr[0];
		int index=0;
		
		cnt[index++]++;
		for(char a:arr) {
			if(a!=prev) {
				cnt[index%2]++;
				index++;
				prev=a;
			}
			else continue;
		}
		
		System.out.println(Math.min(cnt[0], cnt[1]));
	}

}
