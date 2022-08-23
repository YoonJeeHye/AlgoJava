class Solution {
    public int solution(int n, int[][] results) {
        int[][] dist = new int[n+1][n+1];
        for(int[] x : results){
            dist[x[0]][x[1]] = 1;
            dist[x[1]][x[0]] = -1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(dist[i][j]==1 && dist[j][k]==1){
                        dist[i][k]=1;
                        dist[k][i]=-1;
                    }
                    if(dist[i][j]==-1 && dist[j][k]==-1){
                        dist[i][k]=-1;
                        dist[k][i]=1;
                    }
                }
            }
        }
        int answer=0;
        for(int i=1; i<=n; i++){
            int cnt=0;
            for(int j=1; j<=n; j++){
                if(dist[i][j]!=0) cnt++;
            }
            if(cnt==n-1) answer++;
        }
        return answer;
    }
}