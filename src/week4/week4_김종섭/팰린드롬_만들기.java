package august_4th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class 팰린드롬_만들기 {
	static int Odd;
	static char a, b;
	static boolean canPalindrome;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> queue = new ArrayDeque<Character>();
		StringBuilder sb = new StringBuilder();
		
		char [] palindrome = br.readLine().toCharArray();
		Arrays.sort(palindrome); 
		for (int i = 0; i < palindrome.length; i++) queue.add(palindrome[i]);
		
		System.out.println(queue);
		canPalindrome = true;
		char [] answer = new char [palindrome.length];
		
		if(answer.length % 2 == 0) {
			for (int i = 0; i < answer.length/2; i++) {
				char a= queue.poll(); char b= queue.poll();
				if (a != b) {
					canPalindrome = false;  break;
				}
				answer[i] = a; answer[answer.length-1-i] = b; 
			}
			
		}else {
			for (int i = 0; i < answer.length/2; i++) {
				char a= queue.poll(); char b= queue.poll();
				if (a != b) {
					Odd += 1;
					if(Odd >= 2) {
						canPalindrome = false;  break;
					}
					answer[answer.length/2] = a;
					a = b; b = queue.pollFirst();
					if(b != a) {
						canPalindrome = false;  break;
					}
				}
				answer[i] = a; answer[answer.length-1-i] = b;
			}
			if(Odd == 0) answer[answer.length/2] = queue.poll();
			
		}
		for (int i = 0; i < answer.length; i++) {
			sb.append(answer[i]);
		}
		if(canPalindrome) System.out.println(sb);
		else System.out.println("I'm Sorry Hansoo");

	}

}
