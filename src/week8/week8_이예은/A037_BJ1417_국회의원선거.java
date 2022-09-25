package week8.week8_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class A037_BJ1417_국회의원선거 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int dasom = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); // 득표수가 큰 사람 부터 나오도록 한다
		
		for(int i = 0; i < N-1; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n >= dasom) { // 다솜보다 같거나 큰 득표수를 우선순위 큐에 넣는다
				pq.add(n);
			}
		}
		
		int count = 0;
		while(!pq.isEmpty()) { // 우선순위 큐가 비었다는 건 다솜보다 큰 득표수를 가진 사람이 없다는 걸 의미 한다
			int n = pq.poll();
			if(n < dasom) continue;
			dasom++; 
			pq.add(--n);
			count++;
		}

		bw.append(count+"");
		bw.flush();
		br.close();
		bw.close();

	}
}


