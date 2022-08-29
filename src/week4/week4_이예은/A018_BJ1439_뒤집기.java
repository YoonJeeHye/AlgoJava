package week4.week4_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A018_BJ1439_뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		String S = br.readLine();
		
		// 처음 시작 숫자에 따라 달라진다
		// 처음 시작 숫자가 0이라면 0 -> 1 상태 변할 때 count++;
		// 처음 시작 숫자가 1이라면 1 -> 0 상태 변할 때 count++;
		int prev = S.charAt(0) - '0';
		int start = prev;
		int count = 0;
		for(int i = 1; i < S.length(); i++) {
			int cur = S.charAt(i) - '0';
			if(prev != cur && start != cur) { //
				count++;
			}
			prev = cur;
		}
		bw.write(count + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
