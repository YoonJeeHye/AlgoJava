package week9.week9_양주연;

import java.io.*;
import java.util.*;
public class 전쟁전투{
    
    static int N, M, whitePower, bluePower;
    static int[] dx={-1, 0, 1, 0}, dy={0, 1, 0, -1}; //방향 배열
    static char[][] map;
    static class Coor{ //좌표 클래스
        int x, y;
        Coor(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int bfs(int x, int y, char c){
        int cnt=0;
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(x, y));
        cnt++;
        map[x][y] = 'X'; //방문한 곳은 'X'로 바꿔줌.
        while(!q.isEmpty()){
            Coor tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=0 && nx<M && ny>=0 && ny<N && map[nx][ny]==c){
                    map[nx][ny] = 'X'; //방문한 곳은 'X'로 바꿔줌.
                    cnt++;
                    q.offer(new Coor(nx, ny));
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); //열
        M = Integer.parseInt(input[1]); //행
        map = new char[M][N];
        for(int i=0; i<M; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = line.charAt(j);
            }
        }
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]!='X'){
                    if(map[i][j]=='W'){
                        int cnt = bfs(i, j, 'W'); //매개변수 c가 W이면 모여있는 흰색 옷 병사들 카운트
                        whitePower+=Math.pow(cnt, 2);
                    }
                    else if(map[i][j]=='B'){
                        int cnt = bfs(i, j, 'B'); //매개변수 c가 B이면 모여있는 파란색 옷 병사들 카운트 
                        bluePower+=Math.pow(cnt, 2);
                    }
                }
            }
        }
        bw.write(whitePower+" "+bluePower+"\n");
        br.close();
        bw.flush();
        bw.close();
     }
}