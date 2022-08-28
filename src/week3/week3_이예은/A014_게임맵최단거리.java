package week3.week3_이예은;

import java.util.*;

class A014_게임맵최단거리 {
    
    public int BFS(int[][] maps){
        int[] dy = {-1, 1, 0, 0}; // 상하 좌우 4방향으로 움직인다
        int[] dx = {0, 0, -1, 1};
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m]; // 방문체크 초기화
        
        Queue<int[]> queue = new LinkedList<int[]>();
        visited[0][0] = true;
        queue.offer(new int[]{1, 0, 0}); //큐에는 {깊이, y, x} 순으로 저장한다
        
        while(!queue.isEmpty()){ // 큐가 빌때 까지 계속 탐색한다
            int[] cur = queue.poll();
            int depth = cur[0];
            int y = cur[1];
            int x = cur[2];
            if(y == n-1 && x == m-1) return depth; //  BFS 이기 때문에 적의 진영에 처음도착했을 때가 최단경로를 의미한다
            
            for(int i = 0; i < 4; i++){ // 4방향을 탐색한다
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny < 0 || ny >= n || nx < 0|| nx >= m) continue; // 범위를 벗어나면 더이상 탐색하지 않는다
                if(maps[ny][nx] == 0 || visited[ny][nx]) continue; // 벽이 있거나, 전에 방문했다면 더이상 탐색하지 않는다.
                
                // 방문한 적이 없고 길이 있다면
                visited[ny][nx] = true;// 방문을 표시
                queue.offer(new int[]{depth+1, ny, nx});// 큐에 다음에 가야할 위치를 그래프의 degree와 함께 넣어준다
            }
        }
        return -1;    
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        answer = BFS(maps);
        return answer;
    }
}