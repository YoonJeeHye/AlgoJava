package week7.week7_양주연;

import java.io.*;
import java.util.*;
public class 행복유치원
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int[] diff = new int[N-1];
		input = br.readLine().split(" ");
		int prev = Integer.parseInt(input[0]);
		for(int i=1; i<N; i++){
		    int cur = Integer.parseInt(input[i]);
		    diff[i-1] = cur - prev;
		    prev = cur;
		}
		Arrays.sort(diff);
		int cost=0;
		for(int i=0; i<N-K; i++){
		    cost+=diff[i];
		}
		bw.write(cost+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}