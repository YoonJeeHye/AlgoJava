import java.util.*;
class Solution {
    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0}; //방향 배열 {우, 하, 좌, 상}
    int[][] dist; //해당 칸에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값
    int row, col; 
    
    class Coor{ //좌표 클래스
        int x, y;
        Coor(int x, int y){
            this.x=x; //행
            this.y=y; //열
        }
    }
    
    void bfs(int[][] maps){
        Queue<Coor> q = new ArrayDeque<>(); //큐 생성
        dist = new int[row][col];
        q.offer(new Coor(0,0)); //첫번째 칸의 좌표 큐에 넣음
        maps[0][0]=0; //방문한 곳은 벽으로 만듦(방문체크).
        dist[0][0]=1; //첫번째 칸도 포함해서 세기 때문에 첫번째 칸에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 1로 저장 
        while(!q.isEmpty()){ //큐에 원소가 있는 한 반복
            Coor tmp = q.poll(); //큐에서 좌표 꺼내옴
            for(int i=0; i<4; i++){ //방향배열 크기만큼 반복 {우, 하, 좌, 상}
                int nx = tmp.x+dx[i]; //새 x좌표
                int ny = tmp.y+dy[i]; //새 y좌표
                if(nx>=0 && nx<row && ny>=0 && ny<col && maps[nx][ny]==1){ //새 좌표가 배열 범위 안이고 벽이 아닐 경우
                    q.offer(new Coor(nx, ny)); //큐에 넣음
                    maps[nx][ny] = 0; //방문한 곳은 벽으로 만듦(방문체크).
                    dist[nx][ny] = dist[tmp.x][tmp.y]+1; //다음 칸에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 이전 칸에서 구했던 최솟값+1로 저장
                }
            }
        }
        
    }
    
    public int solution(int[][] maps) {
        row = maps.length; //행
        col = maps[0].length; //열
        bfs(maps); //bfs() 호출
        if(dist[row-1][col-1]==0) return -1; //상대 팀 진영에 도착할 수 없을 때는 -1을 return
        else return dist[row-1][col-1]; //도착 가능할 때는 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return
    }
}