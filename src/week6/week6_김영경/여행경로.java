import java.util.*;

class 여행경로 {
    
    int size=0;
    String[] ans;
    boolean flag=false;
    Deque<Integer> dq=new ArrayDeque<>();
    ArrayList<String> airlist;
    
    public void dfs(int level,int start, int[][] map){
        if(flag) return;
        if(level==size){
            int ssize=dq.size();
            ans=new String[ssize+1];
            for(int i=0;i<ssize;i++){
                ans[i+1]=airlist.get(dq.pollFirst());
            }
            flag=true;
            return;
        }
        for(int i=0;i<map.length;i++){
            if(map[start][i]==0)
                continue;
            map[start][i]--;
            dq.add(i);
            dfs(level+1,i,map);
            if(flag) return;
            map[start][i]=1;
            dq.pollLast();
        }
        return;
    }
    
    public String[] solution(String[][] tickets) {
        Set<String> airset=new HashSet<>();
        size=tickets.length;
        for(String[] s:tickets){
            airset.add(s[0]);
            airset.add(s[1]);
        }
        airlist=new ArrayList<>(airset);
        
        Collections.sort(airlist);
        
        int[][] map=new int[airlist.size()][airlist.size()];
        
        for(String[] s:tickets){
            map[airlist.indexOf(s[0])][airlist.indexOf(s[1])]++;
        }
        int start=airlist.indexOf("ICN");
        
        
        dfs(0,start,map);
        ans[0]="ICN";
        
        
        return ans;
    }
}