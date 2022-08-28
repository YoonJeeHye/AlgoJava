package week4.week4_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A017_BJ1213_팰린드롬만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int[] count = new int[26];
		char[] inputs = br.readLine().toCharArray();
		int N = inputs.length;
		
		/*-----------------------입력 끝------------------------*/
		
		for(int i = 0; i < N; i++) { // 알파벳의 갯수를 센다
			count[inputs[i] - 'A']++;
		}
		
		int isOdd = 0;
		for(int i = 0; i < 26; i++) { // 알파벳 개수가 홀수인 알파벳을 센다
			isOdd += count[i] % 2 == 1? 1: 0;
		}
		
		char[] result = new char[N]; // 팰린드롬을 만들 char 배열 초기화
		if(isOdd > 1) {// 알파벳 개수가 홀수 인 알파벳이 1개 이상이면 팰린드롬을 만들 수 없다
			sb.append("I'm Sorry Hansoo");
		} else {
			isOdd = -1;
			int index = 0;
			for (int i = 0; i < 26; i++) { // 저장된 알파벳을 돌면서 팬린드롬을 사전순으로 가장 빠르게 만든다
				if (count[i] % 2 == 1) {
					isOdd = i;
				}

				for (int j = 0; j < count[i]/2; j++) {
					result[index] = (char) (i + 'A');// 앞에서 넣기
					result[N-1-index] = (char) (i + 'A'); // 뒤에서 넣기
					index++;
				}
			}
			
			if(isOdd != -1) {
				result[N/2] = (char) (isOdd + 'A');//알파벳 겟수가 홀수인 알파벳이 있었다면 중간에 넣어준다
			}
			
			for(int i = 0; i < N; i++) {//StringBuffer에 알파벳을 쌓는다
				sb.append(result[i]);
			}
		}
		
		/*-----------------------출력 -----------------------*/
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
