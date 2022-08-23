package week3.week3_양주연;

class Solution {
    static boolean[] chk;
    static void dfs(int cur, int n, int[][] computers){
        chk[cur]=true;
        for(int i=0; i<n; i++){
            if(computers[cur][i]==1 && !chk[i]){
                dfs(i, n, computers);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer=0;
        chk = new boolean[n];
        for(int i=0; i<n; i++){
            if(!chk[i]){
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
}