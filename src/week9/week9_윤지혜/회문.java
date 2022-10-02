package week9.week9_윤지혜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// 시간초과
public class 회문 {

	static StringBuffer sb;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			String s = sc.next();
			s = s.toLowerCase();
			sb = new StringBuffer();
			sb.append(s);
			
			boolean P = IsPalindrome(sb);
			if(P) {	// 회문 확인
				System.out.println(0);
				continue;
			}else {	// 회문 아닐 경우, 유사회문인지 그냥 문자열인지 확인
				boolean simP = IsSimPalindrome(sb);
				if(simP) {		// 유사회문 확인
					System.out.println(1);
					continue;
				}else {
					System.out.println(2);
					continue;
				}
			}
		
		}
	}

	private static boolean IsSimPalindrome(StringBuffer s) {
		int[] alph = new int[26];
		for(int i = 0; i < s.length(); i++) {
			alph[s.charAt(i)-'a']++;
		}
		ArrayList<Character> list = new ArrayList<>();
		boolean haveOdd = false;
		for(int i = 0; i < 26; i++) {
			if(alph[i] % 2 == 1) {
				list.add((char) ('a'+i));
				haveOdd = true;
			}
		}
		
		for(int i = 0; i < s.length()/2; i++) {
			boolean isP = false;
			if(haveOdd) {
				if(s.charAt(i) != s.charAt(s.length()-1-i)) {
					for(int j = 0; j < list.size(); j++) {
						if(s.charAt(i) == list.get(j)) {
							s.deleteCharAt(i);
							isP = IsPalindrome(s);
							if(isP) return true;
							else {
								s.insert(i, s.charAt(i));
								continue;
							}
						}
						else if(s.charAt(s.length()-1-i) == list.get(j)) {
							s.deleteCharAt(s.length()-1-i);
							isP = IsPalindrome(s);
							if(isP) return true;
							else {
								s.insert(i, s.charAt(i));
								continue;
							}
						}
					}
					
				}
			}else {
				if(s.charAt(i) != s.charAt(s.length()-1-i)) {
					s.deleteCharAt(i);
					break;
				}
			}
			
		}
		return false;
		
		
	}

	private static boolean IsPalindrome(StringBuffer s) {
		int cnt = 0;
		for(int i = 0; i < s.length()/2; i++) {
			if(s.charAt(i) == s.charAt(s.length()-1-i)) cnt++;
		}
		if(cnt == s.length()/2) return true;
		else return false;
	}



}
