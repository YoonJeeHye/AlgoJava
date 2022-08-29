package august_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 문자열_집합_조합하기 {
	
	public static int k;
	public static char[] X,Y,Z,S;
	public static StringBuilder sb;
	public static ArrayList<String> list = new ArrayList<>();
	public static Set<String> set = new HashSet<>();
	
	public static void Combi(int index, int start, char[] arr) {
		if(index == k) {
			sb = new StringBuilder();
			for (int i = 0; i < S.length; i++) sb.append(S[i]);
			
			String s = sb.toString();
			if(list.contains(s)) {
				set.add(s);
				return;
			}
			list.add(s);			
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			S[index] = arr[i];
			Combi(index+1, i+1, arr);
		}	
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = br.readLine().toCharArray();
		Y = br.readLine().toCharArray();
		Z = br.readLine().toCharArray();
		k = Integer.parseInt(br.readLine());
		S = new char[k];
		Combi(0,0,X);
		Combi(0,0,Y);
		Combi(0,0,Z);
		
		Object[] newarr = set.toArray();
		Arrays.sort(newarr);
		sb = new StringBuilder();
		if(set.isEmpty()) System.out.println(-1);
		else {
			for (int i = 0; i < set.size(); i++) {
				if(i == set.size()-1) {
					sb.append(newarr[i]);
					break;
				}
				sb.append(newarr[i]).append("\n");
			}
			
		}System.out.println(sb);
	}

}
