package week12.week12_윤지혜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//틀린 알고리즘
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int N = Integer.parseInt(br.readLine());	// 문자의 개수
	String line = br.readLine();	// N개의 char로 이루어진 String
	
	// D, L, U, R 순서로 저장
	int[][] d = {{1,0}, {0,-1}, {-1,0}, {0,1}};
	int r = 1;	// 배열 크기 정해줄 변수
	int c = 1;	// 배열 크기 정해줄 변수
	int cnt = 1;	// R 또는 L로 쭉 얼마나 가는지 담는 변수
	int temp = 0;
	for(int n = 0; n < N-1; n++) {	// line에 저장된 문자 하나하나 확인
		if(line.charAt(n) != 'F') {	// F 아닌 경우(방향만 전환)
			if(line.charAt(n) == line.charAt(n+1)) cnt++;	// R이나 L 같은 문자가 연속해서 나오면 cnt 올려줌
			else if(line.charAt(n) != line.charAt(n+1) && line.charAt(n+1) != 'F') cnt--;	// 같은 문자가 연속해서 나오지 않으면 cnt 내려줌
		}else {	// F인 경우
//			System.out.println("cnt: "+cnt);
//			System.out.println("temp: "+temp);
			temp = (temp+cnt) % 4;	// 가야하는 방향 계산
			cnt = 1;
			if(temp == 0 || temp == 2) r++;	// U 또는 D이면 행 크기 더하기
			else if(temp == 1 || temp == 3) c++;	// L 또는 R이면 열 크기 더하기
//			System.out.println("after temp: "+temp);
		}
	}
	
	// 마지막(N-1번째)것 확인
	if(line.charAt(N-1) == 'F') {
		temp = (temp+cnt) % 4;	// 가야하는 방향 계산
		if(temp == 0 || temp == 2) r++;	// U 또는 D이면 행 크기 더하기
		else if(temp == 1 || temp == 3) c++;	// L 또는 R이면 열 크기 더하기
	}
	
	System.out.println("r: "+r+", c: "+c);
	
}