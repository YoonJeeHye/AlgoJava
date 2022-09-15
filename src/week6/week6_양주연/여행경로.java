package week6.week6_양주연;

import java.util.*;
class Solution {
    boolean[] isSelected;
    PriorityQueue<String> pq;
    
    public String[] solution(String[][] tickets) {
        isSelected = new boolean[tickets.length];
        pq = new PriorityQueue<>();
        dfs(0, "ICN", tickets, "ICN");
        String[] answer = pq.poll().split(",");
        return answer;
    }
    
    public void dfs(int lev, String currentAirport, String[][] tickets, String path){
        if(lev==tickets.length){
            pq.offer(path);
        }
        else{
            for(int i=0; i<tickets.length; i++){
                if(!isSelected[i] && tickets[i][0].equals(currentAirport)){
                    isSelected[i]=true;
                    dfs(lev+1, tickets[i][1], tickets, path+","+tickets[i][1]);
                    isSelected[i]=false;
                }
            }
        }
    }
}