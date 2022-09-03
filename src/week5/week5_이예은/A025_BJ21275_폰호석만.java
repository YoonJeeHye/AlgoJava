package week5.week5_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class A025_BJ21275_폰호석만 {
	static int count;
	static HashMap<Character, Integer> map;

	public static int trans(String str, int nary) {
		int result = 0;
		int N = str.length();
		int flag = 1;
		
		for(int i = N-1; i >= 0; i--) {
			result += map.get(str.charAt(i)) * flag;
			flag *= nary;
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		String[] inputs = br.readLine().split(" ");
		String a = inputs[0];
		String b = inputs[1];
		map = new HashMap<>();
		
		for(int i = 0; i < 10; i++) {
			map.put((char)(i + '0'), i);
		}
		for(int i = 0; i < 26; i++) {
			map.put((char)(i + 'a'), i + 10);
		}
		
		int a_max = Integer.MIN_VALUE;
		int b_max = Integer.MIN_VALUE;
		
		for(int i = 0; i < a.length(); i++) {
			int n = map.get(a.charAt(i));
			a_max = n < a_max ? a_max: n; 
		}
		
		for(int i = 0; i < b.length(); i++) {
			int n = map.get(b.charAt(i));
			b_max = n < b_max ? b_max: n; 
		}
		
		int A = 0, B = 0, X = 0;
		int count = 0;
		for(int i = a_max + 1; i < 37; i++) {
			for(int j = b_max + 1; j < 37; j++) {
				if(i == j) continue;
				int trans_a = trans(a, i);
				if(trans_a == trans(b, j) && trans_a < Math.pow(2, 63))
				{
					A = i;
					B = j;
					X = trans_a;
					count++;
				}
			}
		}
			
		if(count == 0) {
			sb.append("Impossible");
		} else  if(count > 1) {
			sb.append("Multiple");
		} else {
			sb.append(X + " " + A +" " + B);
		}
		
		/*---------------출력----------------*/
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
