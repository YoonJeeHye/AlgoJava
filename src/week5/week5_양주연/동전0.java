package week5.week5_양주연;

import java.io.*;
public class 동전0
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int K = Integer.parseInt(input[1]);
	    int[] unit = new int[N];
	    for(int i=0; i<N; i++){
	        unit[i] = Integer.parseInt(br.readLine());
	    }
	    int count=0;
	    for(int i=N-1; i>=0; i--){
	        if(unit[i]<=K){
	            count+=K/unit[i];
	            K%=unit[i];
	        }
	    }
	    bw.write(count+"\n");
	    br.close();
	    bw.flush();
	    bw.close();
	}
}