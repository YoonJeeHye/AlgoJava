package week6.week6_양주연;

import java.io.*;
import java.util.*;
public class 에너지드링크
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int N = Integer.parseInt(br.readLine()); //에너지 드링크의 수
	    Integer[] drinks = new Integer[N]; //각 에너지 드링크의 양
	    String[] input = br.readLine().split(" ");
	    for(int i=0; i<N; i++){
	        drinks[i] = Integer.valueOf(input[i]);
	    }
	    Arrays.sort(drinks, Collections.reverseOrder()); //내림차순 정렬
	    //10 9 6 3 2 가 있으면 10으로 answer 초기화 후
	    //나머지 에너지 드링크 양 전부 2로 나눠 10에 더함.
	    double answer = drinks[0];
	    for(int i=1; i<N; i++){
	        answer+=drinks[i]/2.0; 
	    }
	    bw.write(answer+"\n");
	    br.close();
	    bw.flush();
	    bw.close();
	}
}