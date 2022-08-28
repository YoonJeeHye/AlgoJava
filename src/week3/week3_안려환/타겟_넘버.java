package week3.week3_안려환;

import java.util.LinkedList;
import java.util.Queue;

public class 타겟_넘버 {

	class Solution {
	    
	    class Pos {
	        int cur;
	        int index;
	        
	        Pos(int cur, int index) {
	            this.cur = cur;
	            this.index = index;
	        }
	    }
	    
	    public int solution(int[] numbers, int target) {
	        int answer = 0;
	        
	        Queue<Pos> queue = new LinkedList<Pos>();
	        queue.offer(new Pos(numbers[0], 0));
	        queue.offer(new Pos(-numbers[0], 0));

	        while (!queue.isEmpty()) {
	        	Pos p = queue.poll();
	            if (p.index == numbers.length-1) {
	                if (p.cur == target) {
	                    answer += 1;
	                }
	                continue;
	            }
	            int c1 = p.cur + numbers[p.index+1];
	            int c2 = p.cur - numbers[p.index+1];
	            
	            queue.add(new Pos(c1, p.index+1));
	            queue.add(new Pos(c2, p.index+1));
	        }

	        return answer;
	    }
	}

}
