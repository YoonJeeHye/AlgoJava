package week3.week3_김영경;

import java.util.*;
class Solution {
    HashSet<Integer>[] lose;
    HashSet<Integer>[] win;
    int N;
    
    public int bfs(int n,HashSet<Integer>[] lose1){
        Queue<Integer> q=new ArrayDeque<>();
        boolean[] visited=new boolean[N];
        q.add(n);
        int cnt=0;
        while(!q.isEmpty()){
            int a=q.poll();
            if(visited[a]==true)continue;
            visited[a]=true;
            for(int tmp:lose1[a])
                q.add(tmp);
            cnt++;
        }
        System.out.println(n+"은 "+(cnt-1));
        return cnt-1;
    }
    
    
    
    public int solution(int n, int[][] results) {
        N=n;
        lose=new HashSet[n];
        win=new HashSet[n];
        for(int i=0;i<n;i++){
            lose[i]=new HashSet<>();
            win[i]=new HashSet<>();
        }
        
        for(int[] tmp:results){
            lose[tmp[1]-1].add(tmp[0]-1);
            win[tmp[0]-1].add(tmp[1]-1);
        }
        
        int cnt=0;
        for(int i=0;i<n;i++){
            if(bfs(i,lose)+bfs(i,win)==n-1)
                cnt++;
        }
        
        return cnt;
    }
}
