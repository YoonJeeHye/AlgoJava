package week1.week1_김종섭.src.august_1th;

import java.util.Deque;
import java.util.LinkedList;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class 올바른괄호 {

	
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> deq = new LinkedList<>();
        for (char c : s.toCharArray()) {
        	
        	switch (c) {
			case '(':
				deq.offerFirst(c);
				System.out.println(deq);
				break;
				
			default:
				if(deq.isEmpty()) return false;
				deq.pollLast();
				System.out.println(deq);
				break;
			}
        }

        return deq.isEmpty();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		올바른괄호 ar1 = new 올바른괄호();
		String s1 = "()()()";
		System.out.println(ar1.solution(s1));
	}

}
