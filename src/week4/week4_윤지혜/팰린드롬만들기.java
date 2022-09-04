package week4.week4_윤지혜;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj_팰린드롬만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		ArrayList<Character> chars = new ArrayList<>();
		
		for(int i = 0; i < s.length(); i++) {
			chars.add(s.charAt(i));
		}

		// 1. 문자열 정렬
		Collections.sort(chars);
		
		// 2. 문자열에 있는 각 알파벳 개수 세기
		// 3-1. 알파벳 개수가 홀수인 것이 2개 이상이면 불가능
		ArrayList<Integer> alph_cnt = new ArrayList<>();
		int cnt = 1;
		int odd_cnt = 0;
		char odd = ' ';	// 홀수인 문자 잡아놓기
		for(int i = 0; i < s.length()-1; i++) {
			if(chars.get(i) == chars.get(i+1)) {
				cnt++;
			}else {
				if(cnt%2==1) {	// 3-1
					odd_cnt++;
					odd = chars.get(i);
				}
				alph_cnt.add(cnt);
				cnt = 1;
			}
		}
		if(cnt%2==1) {	// 3-1
			odd_cnt++;
			odd = chars.get(s.length()-1);
		}
		alph_cnt.add(cnt);
		
		// 3-1
		if(odd_cnt >= 2) System.out.println("I'm Sorry Hansoo");
		
		// 3-2. 그게 아니라면 가능 -> 팰린드롬 구하기
		else {
			int org_size = chars.size();
			char answer[] = new char[chars.size()];
			
			for(int i = 0; i < chars.size(); i++) {
				if(odd == chars.get(i)) {	// 홀수개인 알파벳 1개 가운데에 넣어주기
					answer[chars.size()/2] = odd;
					chars.remove(i);
					break;
				}
			}
			
			int ans_size = chars.size();
			for(int i = 0, index = 0; i < ans_size/2; i++) {
				answer[i] = chars.get(index);
				index++;
				if(org_size%2 == 0) answer[ans_size-1-i] = chars.get(index);
				else answer[ans_size-i] = chars.get(index);
				index++;
			}
		
			
			for(char c : answer) {
			System.out.print(c);
			}
			
		}
	}

}
