package week3.week3_안려환;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

	 public static int solution(int[][] maps) {
	        int n = maps.length;
	        int m = maps[0].length;

	        boolean[][] visited = new boolean[n][m];
	        Queue<int[]> queue = new LinkedList<>();
	        visited[0][0] = true;
	        queue.add(new int[] {0,0,1}); 

	        int[] dx = {-1,1,0,0};
	        int[] dy = {0,0,1,-1};
	        int answer = 0;

	        while(queue.isEmpty() == false){
	            int[] currPoint = queue.remove();
	            if(currPoint[0] == n-1 && currPoint[1] == m-1){
	                return currPoint[2];
	            }
	            for (int i = 0; i < 4; i++) {
	                int xx = dx[i] + currPoint[0];
	                int yy = dy[i] + currPoint[1];
	                if(xx >= 0 && xx < n && yy >= 0 && yy < m){
	                    if(maps[xx][yy] == 1 && !visited[xx][yy]){
	                        visited[xx][yy] = true;
	                        queue.add(new int[] {xx, yy, currPoint[2]+1});
	                    }
	                }

	            }
	        }
	        return -1;
	    }

}
