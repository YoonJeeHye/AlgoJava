package week6.week6_양주연;

import java.io.*;
import java.util.*;
public class YonseiTOTO
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    String[] input = br.readLine().split(" ");
	    int n = Integer.parseInt(input[0]); //과목 수
	    int m = Integer.parseInt(input[1]); //쓸 수 있는 총 마일리지
	    int[] sMile = new int[n]; //성준이가 과목 별로 해당 과목 듣기위해 사용해야하는 마일리지의 최솟값 저장할 배열 (마일리지를 매 경우 최소로 써야 과목 개수 최대로 들을 수 있음)
	    for(int subNum=0; subNum<n; subNum++){ //과목수만큼 반복
	        input = br.readLine().split(" ");
	        int P = Integer.parseInt(input[0]); //과목에 신청한 사람 수
	        int L = Integer.parseInt(input[1]); //과목의 수강인원
	        Integer[] mile = new Integer[P]; //각 사람이 마일리지를 얼마나 넣었는지
	        input = br.readLine().split(" ");
	        for(int i=0; i<P; i++){
	            mile[i] = Integer.valueOf(input[i]);
	        }
	        Arrays.sort(mile, Collections.reverseOrder()); //각 사람의 마일리지 내림차순 정렬
	        //1. 신청자 수 >= 수강인원인 경우 :
	        //신청자 수 5명, 수강인원 4명이라 하고
	        //내림차순 정렬한 각 사람의 마일리지가 36 36 36 25 1이라고 하면
	        //앞에서 네번째 사람의 마일리지와 같은 양의 마일리지 사용하면 
	        //마일리지 최소로 사용하여 수강인원에 포함될 수 있음. (마일리지가 같다면 성준이에게 우선순위 주어지므로.)
	        //2. 신청자 수 < 수강인원인 경우 :
	        //어차피 얼마를 써도 수강인원에 포함되므로
	        //가장 최소로 사용하는 1 마일리지 사용.
	        if(P>=L) sMile[subNum] = mile[L-1]; //1.
	        else sMile[subNum] = 1; //2.
	    }
	    Arrays.sort(sMile); //성준이가 과목 별 사용해야하는 마일리지 오름차순 정렬
	    int sum=0, cnt=0;
	    for(int x : sMile){ //앞에서부터 마일리지 누적해가면서 cnt에 1씩 더하고 쓸 수 있는 총 마일리지 초과하면 멈춤.
	        sum+=x;
	        if(sum>m) break;
	        cnt++;
	    }
	    bw.write(cnt+"\n");
	    br.close();
	    bw.flush();
	    bw.close();
	}
}