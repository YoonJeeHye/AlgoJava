package week6.week6_양주연;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        for(int[] idx : puddles){
            dp[idx[1]][idx[0]]=-1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i==1 && j==1) dp[i][j]=1;
                else if(dp[i][j]==-1) dp[i][j]=0;
                else dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000007;
            }
        }
        return dp[n][m];
    }
}