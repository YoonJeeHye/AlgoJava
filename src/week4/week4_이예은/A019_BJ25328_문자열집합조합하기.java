package week4.week4_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class A019_BJ25328_문자열집합조합하기 {

	static int k;
	static String X, Y, Z;
	static HashMap<String, Integer> hashmap; // hashmap에 조합의 결과를 key로 하고 count를 value로 해서 저장한다

	public static void combination(String str, int N, int cnt, int index, char[] path) {
		if (cnt == k) {
			String key = new String(path);
			
			if(hashmap.containsKey(key)) { 
				int val = hashmap.get(key);
				hashmap.put(key, val + 1); // hashmap에 들어 있는 결과라면 cnt+1을 해준다
			} else {
				hashmap.put(key, 1); // hashmap에 안들어 있던 결과라면 cnt = 1로 해준다
			}
			return;
		}

		for (int i = index; i < N; i++) {
			path[cnt] = str.charAt(i);
			combination(str, N, cnt + 1, i + 1, path);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();

		X = br.readLine();
		Y = br.readLine();
		Z = br.readLine();
		k = Integer.parseInt(br.readLine());
		/*--------------입력끝--------------*/
		hashmap = new HashMap<>();
		
		combination(X, X.length(), 0, 0, new char[k]);
		combination(Y, Y.length(), 0, 0, new char[k]);
		combination(Z, Z.length(), 0, 0, new char[k]);

		ArrayList<String> result = new ArrayList<>(); // hashmap을 통해서 조합을 결과가 2번이상 나온 조합을 result에 넣는다
		for(String key : hashmap.keySet()) {
			if(hashmap.get(key) > 1) {
				result.add(key);
			}
		}
		
		Collections.sort(result);// 결과를 오름차순으로 정렬한다
		if(result.size() == 0) {// 2번이상 나온 조합이 없을때는 -1을 출력한다
			sb.append(-1);
		} else {
			for(int i = 0; i < result.size(); i++) { // StringBuffer에 정답을 쌓는다
				sb.append(result.get(i)).append("\n");
			}
		}
		/*---------------출력----------------*/
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
