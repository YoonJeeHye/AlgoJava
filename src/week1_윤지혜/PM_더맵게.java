package week1_윤지혜;

import java.util.*;

// 실패 ㅠ
public class PM_더맵게 {
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        Arrays.sort(scoville);
        
        for(int i = 0; i < scoville.length; i++) {
        	queue.add(scoville[i]);
        }
        
        if(queue.peek() < K && queue.size() <= 1) {
        	answer = -1;
        }
        
        while(queue.peek() < K && queue.size() >= 2) {
        	
        	if(queue.isEmpty()) {
        		answer = -1;
        	}
        	
        	int A = queue.peek();
        	queue.poll();
        	int B = queue.peek();
        	queue.poll();
        	
        	queue.add(A+B*2);
        	answer++;
        }

        return answer;
    }

	public static void main(String[] args) {
		
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		solution(scoville, K);

	}

}
