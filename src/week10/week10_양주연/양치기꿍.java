package week10.week10_양주연;

import java.io.*;
import java.util.*;
public class 양치기꿍{
    
    static int R, C, sheepTotal, wolfTotal;
    static int[] dx={-1, 0, 1, 0}, dy={0, 1, 0, -1};
    static char[][] map;
    static class Coor{
        int x, y;
        Coor(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static void bfs(int x, int y){
        int wolfCnt=0, sheepCnt=0;
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(x, y));
        if(map[x][y]=='v') wolfCnt++;
        else if(map[x][y]=='k') sheepCnt++;
        map[x][y] = '#';
        while(!q.isEmpty()){
            Coor tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]!='#'){
                    q.offer(new Coor(nx, ny));
                    if(map[nx][ny]=='v') wolfCnt++;
                    else if(map[nx][ny]=='k') sheepCnt++;
                    map[nx][ny] = '#';
                }
            }
        }
        if(sheepCnt>wolfCnt) wolfTotal-=wolfCnt;
        else sheepTotal-=sheepCnt;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[R][C];
        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j]=='k') sheepTotal++;
                else if(map[i][j]=='v') wolfTotal++;
            }
        }
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]!='#'){
                    bfs(i, j);
                }
            }
        }
        bw.write(sheepTotal+" "+wolfTotal+"\n");
        br.close();
        bw.flush();
        bw.close();
     }
}