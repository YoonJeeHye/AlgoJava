package week3.week3_양주연;// 다익스트라 풀이
import java.util.*;
class Solution {
    class Edge implements Comparable<Edge>{
        int v, cost;
        Edge(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>(); 
        ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] x : edge){
            adjList.get(x[0]).add(new Edge(x[1],1));
            adjList.get(x[1]).add(new Edge(x[0],1));
        }
        dist[1]=0;
        pq.offer(new Edge(1,0));
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            if(tmp.cost>dist[tmp.v]) continue;
            for(Edge e : adjList.get(tmp.v)){
                int newDist = tmp.cost+e.cost;
                if(dist[e.v]>newDist){
                    dist[e.v] = newDist;
                    pq.offer(new Edge(e.v, newDist));
                }
            }
        }
        int max = 0, cnt=0;
        for(int i=1; i<=n; i++){
            if(dist[i]>max) max = dist[i];
        }
        for(int x : dist){
            if(x==max) cnt++;
        }
        return cnt;
    }
}