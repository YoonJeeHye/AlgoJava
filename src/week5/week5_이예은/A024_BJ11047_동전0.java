package week5.week5_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class A024_BJ11047_동전0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int K = Integer.parseInt(inputs[1]);
		int[] coin = new int[N];
	
		
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());

		}
		
		int total = K;
		int count = 0;
		for(int i = N-1; i >= 0; i--) {
			if(total == 0) break;
			if(total >= coin[i]) {
				count += total/coin[i]; // 동전을 하나씩 빼지 말고 가장 큰 동전의 경우에서 나눈 나머지를 생각한다
				total %= coin[i];
			}
		}
		/*---------------출력----------------*/
		bw.write(count + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
