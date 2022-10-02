package week9.week9_윤지혜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 프린터큐 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int answer = 0;
			// '중요도' 입력을 받을 때
			// queue에 순서대로 저장한다
			Queue<Integer> q = new ArrayDeque<>();
			// priority queue에 중요도 순위대로 저장한다 (내림차순)
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int n = 0; n < N; n++) {
				int k = sc.nextInt();
				q.add(k);
				pq.add(k);
			}
			
			
			int idx = M;
			while(!q.isEmpty()) {
				if(pq.peek() != q.peek()) { // 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다.
					int temp = q.poll();
					q.add(temp);
					idx--;
				}else { // 그렇지 않다면 바로 인쇄를 한다.
					q.poll();
					pq.poll();
					answer++;
					if(idx == 0) break;
					idx--;
				}
				
				if(idx == -1) idx = q.size()-1;	// q의 맨 끝으로 간것임
			}
			
			System.out.println(answer);
		}
	}
}
