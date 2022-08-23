package week3.week3_이예은;

import java.util.ArrayList;

class A012_순위 {
	static boolean[][] win;
	static boolean[][] lose;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adjList;

    public static int solution(int n, int[][] results) {
        
        adjList = new ArrayList<ArrayList<Integer>>(n+1);
        
        win = new boolean[n+1][n+1];
        lose = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        int count = 0;
        
        for(int[] edge: results) { // edge 정보에 따라 win, lose 배열을 채운다
        	int u = edge[0];
        	int v = edge[1];
        	win[u][v] = true;
        	lose[v][u] = true;
        }
        
        for(int[] edge: results) { // edge 정보에 따라 연결된 노드의 win, lose 배열을 채운다
        	int u = edge[0];
        	int v = edge[1];
            win[u][v] = true;
        	lose[v][u] = true;
        	
        	for(int i = 1; i < n+1; i++) { // u를 이긴 노드들을 찾아서 상태를 갱신한다
        		if(!win[i][u]) continue;
        		for(int j = 1; j < n+1; j++) {
        			win[i][j] = (win[u][j]) ? true: win[i][j];
        		}
        	}
        	
        	for(int i = 1; i < n+1; i++) {// v에게 진 노드들을 찾아서 상태를 갱신한다
        		if(!lose[i][v]) continue;
        		for(int j = 1; j < n+1; j++) {
        			lose[i][j] = (lose[v][j]) ? true: lose[i][j];
        		}
        	}
        }
       
       for(int i = 1; i < n+1; i++) {
    	   boolean isSpecified = true;
    	   for(int j = 1; j < n+1; j++) {
    		   if(i == j) continue;
    		   if(win[i][j] || lose[i][j]) { // 모든 노드들에 대해 lose 또는 win의 상태가 있다면 이는 순위를 정확하게 매길 수 있다.
    			   continue;
    		   } else {
    			   isSpecified = false;
    			   break;
    		   }
    	   }
    	   count += isSpecified? 1: 0;
       }
       return count;
	}
}