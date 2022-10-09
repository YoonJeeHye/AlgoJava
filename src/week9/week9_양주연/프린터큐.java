package week9.week9_양주연;

import java.io.*;
import java.util.*;
public class 프린터큐
{
    static int answer, N, M;
    static class Doc{
        int num, importance;
        Doc(int num, int importance){
            this.num=num;
            this.importance=importance;
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
		    String[] input = br.readLine().split(" ");
		    N = Integer.parseInt(input[0]);
		    M = Integer.parseInt(input[1]);
		    answer=0;
		    Queue<Doc> q= new ArrayDeque<>();
		    input = br.readLine().split(" ");
		    for(int i=0; i<N; i++){
		        q.offer(new Doc(i, Integer.parseInt(input[i])));
		    }
		    while(!q.isEmpty()){
		        Doc cur = q.poll();
		        boolean print = true;
		        for(Doc d : q){
		            if(d.importance > cur.importance){
		                print=false;
		                q.offer(new Doc(cur.num, cur.importance));
		                break;
		            }
		        }
		        if(print){
		            answer++;
		            if(cur.num==M) break;
		        }
		    }
		    bw.write(answer+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}