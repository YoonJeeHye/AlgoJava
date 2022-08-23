package august_2th;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class 조이스틱 {

	public int solution(String name) {
		char [] charArr = name.toCharArray();
		int nextLoc = 0, Loc = 0, answer = 0;
		List<Integer> bList = new ArrayList<>();
		
		if(charArr[0] == 'A') bList.add(0);
		// 위 아래 조작
		for (int i = 0; i < name.length(); i++) {
			if(charArr[i] == 'A') continue;
			else bList.add(i);
			Loc = charArr[i]-'A';
			answer += Math.min(Loc, 26-Loc);
			
		}
		System.out.println(bList);
		// 양옆 조작
		for (int i = 0; i < bList.size()-1; i++) {
			if(bList.get(i+1)-bList.get(i) < charArr.length-bList.get(i+1))  {
				answer += bList.get(i+1)-bList.get(i);
				continue;
			}
			else {
				answer += charArr.length-bList.get(i+1);
				break;
			}
		}
		
		
		
/*		Loc = 0; left = 1;
		for (int i = 0; i < charArr.length; i++) {
			if(charArr[i] == 'A') continue;
			else firstB = i; break;
		}
		for (int i = charArr.length-1; i >0; i--) {
			if(charArr[i] == 'A') continue;
			else lastB = i; break; 
		}
		
		for (int i = 1; i < name.length(); i++) {
			nextLoc = i;
			if(charArr[nextLoc] == 'A') {
				continue;
			}
			else {
				// A가 아닐 때	
				if(Loc == 0) left = 0;
				answer += Math.min(nextLoc - Loc, name.length()-Loc-1 + left);
				Loc = nextLoc;
			}
		}*/
        return answer;
    }

}
