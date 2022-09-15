import java.util.*;

class 등굣길 {
    static public class node{
        int x;
        int y;
        node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
    static public int solution(int n, int m, int[][] puddles) {
        int[][] arr=new int[m+2][n+2];
        
        for(int i=0;i<m+2;i++){
            for(int j=0;j<n+2;j++){
                if(i==0 || j==0 || i==m+1 || j==n+1)
                    arr[i][j]=-1;
            }
        }
        
        if(puddles[0].length>0){
        for(int i=0;i<puddles.length;i++){
            arr[puddles[i][1]][puddles[i][0]]=-1;
        }
        }
        arr[1][1]=1;
        
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(arr[i][j]==-1 || (i==1 && j==1)) continue;
                arr[i][j]=((arr[i-1][j]==-1?0:arr[i-1][j])+(arr[i][j-1]==-1?0:arr[i][j-1]))%1000000007;
            }
        }
        
        
        return arr[m][n];
    
    
}
}