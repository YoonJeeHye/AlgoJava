package week7.week7_윤지혜;

import java.util.*;

class Solution {
	
    static boolean[] visited;
	static PriorityQueue<String> pq;
	
	public static String[] solution(String[][] tickets) {
        String[] answer = {};
        
        visited = new boolean[tickets.length];	// 티켓 사용했는지 확인하는 배열
        pq = new PriorityQueue<>();	// 가능한 여행 경로들 모음(알파벳 오름차순으로)
        
        dfs(0, "ICN", "ICN", tickets);
        
        answer = pq.poll().split(" ");
        return answer;
        
    }
    
    private static void dfs(int cnt, String start, String route, String[][] tickets) {
	
		if(cnt == tickets.length) {	// 가능한 경로가 만들어짐
			pq.offer(route);
			return;
		}
		
		for(int i = 0; i < tickets.length; i++) {
			if(start.equals(tickets[i][0]) && !visited[i]) {
				visited[i] = true;
				dfs(cnt+1, tickets[i][1], route+" "+tickets[i][1], tickets);
				visited[i] = false;
			}
		}
	}
}