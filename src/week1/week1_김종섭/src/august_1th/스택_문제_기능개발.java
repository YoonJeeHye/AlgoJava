package week1.week1_김종섭.src.august_1th;

import java.util.*;

public class 스택_문제_기능개발 {

	// 1. 작업완료일을 나타내는 배열을 하나 만든다
	public int[] solution(int[] progresses, int[] speeds) {
	Deque<Integer> done = new LinkedList<>();
	for (int i =0; i<progresses.length; i++) {
		done.offerFirst((int)Math.ceil((100-progresses[i])*1.0/speeds[i]*1.0));
		}
	Deque<Integer> bapo = new LinkedList<>();
	
		int a = done.pollLast();
		int count = 1;
		while (!done.isEmpty()) {
			int b = done.pollLast();
			if(a >= b) {
				count += 1;
				continue;
				}
			else {
				bapo.offerLast(count);
				count = 1;
				a = b;
				}
	        
			}
		bapo.offerLast(count);
		return bapo.stream().mapToInt(Integer :: intValue).toArray();
	}
	
	
	public static void main(String[] args) {
		
		
		

	}

}
