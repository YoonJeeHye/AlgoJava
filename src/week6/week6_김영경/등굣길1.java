import java.util.*;

class 등굣길1 {
    static public class node{
        int x;
        int y;
        node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
    static public int solution(int n, int m, int[][] puddles) {
        int[][] arr=new int[m][n];
        
        if(puddles[0].length>0){
        for(int i=0;i<puddles.length;i++){
            arr[puddles[i][1]-1][puddles[i][0]-1]=1;
        }
        }
        
        //System.out.println(Arrays.deepToString(arr));
        
        Queue<node> q=new ArrayDeque<>();
        
        q.add(new node(0,0));
        
        while(!q.isEmpty()){
            int cnt=0;
            int size=q.size();
            boolean flag=false;
            for(int i=0;i<size;i++){
                node tmp=q.poll();
                if(tmp.x==m-1 && tmp.y==n-1){
                    flag=true;
                    if(cnt+1==1000000007)
                        cnt=0;
                    else cnt++;
                }
                if(tmp.x+1>=m || arr[tmp.x+1][tmp.y]==1){}
                else q.add(new node(tmp.x+1,tmp.y));
                if(tmp.y+1>=n || arr[tmp.x][tmp.y+1]==1){}
                else q.add(new node(tmp.x,tmp.y+1));
            }
            if(flag){
                return cnt;
            }
        }
        
        return 0;
    }
    
    
}