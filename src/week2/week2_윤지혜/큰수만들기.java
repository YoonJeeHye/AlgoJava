package week2.week2_윤지혜;

import java.util.*;

// 1. answer의 길이(ans_len)를 구한다
// 2. number의 뒤쪽부터 ans_len-1만큼의 길이는 안전빵으로 남겨둔다
// 3. 뒤쪽부터 ans_len-1만큼의 길이에 포함되지 않는 앞쪽 중 가장 큰 수를 찾는다
// 4. 앞쪽의 가장 큰 수를 찾았다면, 그 수의 앞 숫자들은 다 제외시킨다
// 5. 답이 되는 수를 하나 찾은것이므로, 뒤쪽부터 ans_len만큼의 길이-1 해준다
// 6. 2~5 반복
public class 큰수만들기 {
	public static String solution(String number, int k) {
		
		StringBuilder sb = new StringBuilder();
		// answer의 길이 = number.length() - k
		int ans_len = number.length()-k;
		
		int max = 0;
		int index = 0;
		for(int i = 0; i < ans_len; i++) {
			max = 0;
			for(int j = index; j <= k+i; j++) {	// 헷갈려~~~~~~~~~~
				max = max < number.charAt(j)-'0' ? number.charAt(j)-'0' : max;
				index = j+1;
			}
			sb.append(max);
		}
	
        return sb.toString();
    }

	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		
	}

}
