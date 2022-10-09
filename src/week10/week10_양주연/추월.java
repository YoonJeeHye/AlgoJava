package week10.week10_양주연;

import java.io.*;
import java.util.*;
public class 추월
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++){
		    map.put(br.readLine(), i);
		}
		int[] res = new int[N];
		for(int i=0; i<N; i++){
		    res[i] = map.get(br.readLine());
		}
		int answer=0;
		int min = Integer.MAX_VALUE;
		for(int i=N-1; i>=0; i--){
		    if(min>res[i]) min=res[i];
		    else answer++;
		}
		bw.write(answer+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}

// map에 저장
// ZG508OK, 0
// PU305A, 1
// RI604B, 2
// ZG206A, 3
// ZG232ZF, 4
// ---------
// PU305A  -> 1
// ZG232ZF -> 4
// ZG206A  -> 3
// ZG508OK -> 0
// RI604B  -> 2
// ---------
// 현재 차 순서보다 더 앞 순서(더 작은 순서값)가 현재 차 뒤에 오면 현재 차는 추월한 차
// for문으로 뒤부터 돌면서 현재까지의 min과 비교하여, 
// 저장한 min보다 더 작을 경우엔 min 업데이트
// 저장한 min보다 클 경우엔(순서니까 같을 경우는 없음) 추월한 차이므로 answer+1.