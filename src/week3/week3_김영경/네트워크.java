package week3.week3_김영경;

import java.util.*;
class Solution {
    int[] parent;

    public int find(int nodenum){
        if(parent[nodenum]<0)
            return nodenum;
        else{
            return parent[nodenum]=find(parent[nodenum]);
        }
    }
        
    public void union(int a,int b){
        int v1=find(a);
        int v2=find(b);
        if(v1!=v2){
            if(parent[v1]<parent[v2]) parent[v2]=v1; //루트가 v1인 집합이 높이(레벨)가 더 높은 트리일 경우. (작은 트리가 큰 트리로 들어가면 높이는 변하지 않음)
            else if(parent[v1]>parent[v2]) parent[v1]=v2; //루트가 v2인 집합이 높이(레벨)가 더 높은 트리일 경우. (작은 트리가 큰 트리로 들어가면 높이는 변하지 않음)
            else{ //두 트리의 레벨이 같다면,
                parent[v1]--; //루트가 v1인 트리쪽으로 합쳐, 해당 트리의 레벨이 1 증가
                parent[v2]=v1;
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        parent=new int[n];
        Arrays.fill(parent,-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)continue;
                else if(computers[i][j]==1)
                    union(i,j);
            }
        }
        int cnt=0;
        for(int i:parent)
            if(i<0)cnt++;
        
        return cnt;
    }
}
