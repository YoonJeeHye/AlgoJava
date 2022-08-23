package week1.week1_이예은;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int temp1, temp2;
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int scov : scoville) {
        	pq.add(scov); // 우선순위 큐에 넣기
        }
        
        while(pq.peek() < K) { // 큐에 들어있는 가장 작은 값이 K보다 커지면 반복을 멈춘다
            if(pq.size() < 2) return -1;
        	temp1 = pq.poll();// 가장 맵지 않은 음식의 스코빌 지수
        	temp2 = pq.poll();// 두 번째로 맵지 않은 음식의 스코빌 지수
        	pq.add(temp1 + temp2 * 2); 
        	answer++;// 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수
        }
        
         return answer;
    }
}