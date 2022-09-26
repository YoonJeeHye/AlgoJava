package week8.week8_양주연;

import java.io.*;
import java.util.*;
public class 국회의원선거
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int dasom=0;
		for(int i=0; i<n; i++){
		    if(i==0) dasom = Integer.parseInt(br.readLine());
		    else pq.offer(Integer.parseInt(br.readLine()));
		}
		int cnt=0;
		while(true){
		    boolean flag=false;
		    if(!pq.isEmpty() && dasom <= pq.peek()){
		        int temp = pq.poll();
		        temp--;
		        dasom++;
		        cnt++;
		        pq.offer(temp);
		    }
		    else break;
		}
		bw.write(cnt+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}