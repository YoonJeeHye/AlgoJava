package august_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 뒤집기 {
	static int count0, count1;
	static char now;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] dasom = br.readLine().toCharArray();
		now = dasom[0]; count0 += 1;
		for (int i = 1; i < dasom.length; i++) {
			if(dasom[i] == now) continue;
			else {
				now = dasom[i];
				if(now == dasom[0]) count0 += 1;
				else count1 += 1;
			}
		}
		System.out.println(Math.min(count0, count1));

	}

}
