package week1.week1_김종섭.src.august_1th;

import java.util.*;

public class 더맵게 {

	 public int solution(int[] scoville, int K) {
		 Queue<Integer> list = new PriorityQueue<>();
		 //Arrays.sort(scoville);
		 for(int s : scoville) {
			 list.offer(s);
		 }
		 int answer = 0;
		 while(list.peek()<K && list.size()>=2) {
			int a =  list.poll();
			int b =  list.poll();
			int c = a + (2*b);
			list.offer(c);
			answer ++;
             
			}
         
         if(list.peek() < K) return -1;
	    
         return answer;
	    }

}
