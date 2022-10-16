package week11.week11_윤지혜;

import java.io.*;
import java.util.*;

// 시간초과
public class 가르침 {

	static int N, K;
	static String[] word;
	static boolean visited[];
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		K = Integer.parseInt(line[1]);
		
		word = new String[N];	// 각 문자열 저장
		for(int n = 0; n < N; n++) {
			word[n] = br.readLine();
			// a c i n t 지우고 남은 것만 보기
			word[n] = word[n].replace("a", "");
			word[n] = word[n].replace("c", "");
			word[n] = word[n].replace("i", "");
			word[n] = word[n].replace("n", "");
			word[n] = word[n].replace("t", "");
		}
		
		answer = 0;
		// anta tica에 필요한 a c i n t도 완성 못하는 경우는 0 출력
		if(K < 5) answer = 0;
		else if(K == 26) answer = N;	// 알파벳 모두 사용 가능
		else {	// K가 5 이상일 경우(anta tica는 완성 가능)
			K -= 5;	// 글자 몇 개 더 가르칠 수 있는지 확인
			
			visited = new boolean[26];	// 알파벳 넣어볼 배열
			visited['a'-'a'] = true;
			visited['c'-'a'] = true;
			visited['i'-'a'] = true;
			visited['n'-'a'] = true;
			visited['t'-'a'] = true;
			
			Comb(0, 0);
		}
		
		System.out.println(answer);
	}

	private static void Comb(int start, int len) {
		
		if(len == K) {	// true인 것들로 배울 수 있는 단어 몇개인지 세어보고 answer 갱신
			int count = 0;
			for(int n = 0; n < N; n++) {
				boolean read = true;
				for(int w = 0; w < word[n].length(); w++) {
					if(!visited[word[n].charAt(w)-'a']) {	// 배울 수 없는 단어
						read = false;
						break;
					}
				}
				if(read) count++;
			}
			answer = Math.max(answer, count);
			return;
		}
		
		for(int i = start; i < 26; i++) {
			if(!visited[i]) {
				visited[i] = true;
				Comb(start+1 ,len+1);
				visited[i] = false;
			}
		}
		
	}
	
}
