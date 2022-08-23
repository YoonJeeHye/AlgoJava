import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        List<Integer>[] eg=new ArrayList[n];
        
        for(int i=0;i<n;i++){
            eg[i]=new ArrayList<>();
        }
        
        for(int[] tmp:edge){
            eg[tmp[0]-1].add(tmp[1]-1);
            eg[tmp[1]-1].add(tmp[0]-1);
        }
        
        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{return o1[1]-o2[1];});
        boolean[] visited=new boolean[n];
        Arrays.fill(visited,false);
        q.add(new int[]{0,0});
        ans[0]=0;
        while(!q.isEmpty()){
            int[] tmp=q.poll();
            System.out.print(tmp[0]+" ");
            if(visited[tmp[0]]==true)continue;
            visited[tmp[0]]=true;
            for(int a:eg[tmp[0]]){
                if(ans[a]>ans[tmp[0]]+1){
                    ans[a]=ans[tmp[0]]+1;
                    q.add(new int[]{a,ans[a]});
                }
            }
        }
        int cnt=0;
        int max=0;
        for(int i:ans){
            if(i>max){
                cnt=1;
                max=i;
            }
            else if(i==max){
                cnt++;
            }
        }
        //for(int i:ans)System.out.print(i+" ");
        
        return cnt;

    }
}
