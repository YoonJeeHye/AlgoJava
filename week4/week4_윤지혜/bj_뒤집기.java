package week4_윤지혜;

import java.util.Scanner;

public class bj_뒤집기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		int cnt_0 = 0;
		int cnt_1 = 0;
		
		// 연속되는 0 뭉터기가 몇개인지, 연속되는 1 뭉터기가 몇개인지 각각 카운트
		for(int i = 0; i < s.length()-1; i++) {
			if(s.charAt(i)=='0' && s.charAt(i+1)=='1') cnt_0++;
			else if(s.charAt(i)=='1' && s.charAt(i+1)=='0') cnt_1++;
		}
		
		// 마지막것은 for문에서 카운트 되지 않아서 따로 카운트
		if(s.charAt(s.length()-1)== '0') cnt_0++;
		else if(s.charAt(s.length()-1)== '1') cnt_1++;
		
		// 연속되는 0, 1 뭉터기 중 더 적은 뭉터기를 바꾸는 것이 최소 교환 횟수
		// 최소 교환 횟수를 출력
		if(cnt_0<cnt_1) System.out.println(cnt_0);
		else System.out.println(cnt_1);
	}

}
