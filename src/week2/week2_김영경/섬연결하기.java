package week2.week2_김영경;

import java.util.*;

class 섬연결하기 {
    
    static public int solution(int n, int[][] costs) {
       // n=5;
        //costs=new int[][] {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}};
        int[][] map=new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(map[i],0);
        for(int i=0;i<costs.length;i++){
            map[costs[i][0]][costs[i][1]]=costs[i][2];
            map[costs[i][1]][costs[i][0]]=costs[i][2];
        }
        int sum=0;
        ArrayList<Integer> t=new ArrayList<>();
        t.add(0);
        while(t.size()<n){
            int min=Integer.MAX_VALUE;
            int idx=-1;
            for(int i:t){
                for(int j=0;j<n;j++){
                    if(t.contains(j))continue;
                    if(map[i][j]!=0 && map[i][j]<min){
                        idx=j;
                        min=map[i][j];
                    }
                }
            }
            t.add(idx);
            sum+=min;
            System.out.println(min);
        }
        return sum;
    }
    
}