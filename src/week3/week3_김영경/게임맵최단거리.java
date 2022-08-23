package week3.week3_김영경;

import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{0,0,1});
        int cnt=0;
        int x=maps.length-1;
        int y=maps[0].length-1;
        while(!q.isEmpty()){
            int[] tmp=q.poll();
            if(tmp[0]==-1 || tmp[1]==-1 ||tmp[0]==x+1 || tmp[1]==y+1 || maps[tmp[0]][tmp[1]]<=0)
                continue;
            if(tmp[0]==x && tmp[1]==y)
                return tmp[2];
            
            maps[tmp[0]][tmp[1]]=-1;
            //System.out.println(tmp[0]+" "+tmp[1]);
            q.add(new int[]{tmp[0]-1,tmp[1],tmp[2]+1});
            q.add(new int[]{tmp[0]+1,tmp[1],tmp[2]+1});
            q.add(new int[]{tmp[0],tmp[1]-1,tmp[2]+1});
            q.add(new int[]{tmp[0],tmp[1]+1,tmp[2]+1}); 
            }
        return -1;
    }
}
