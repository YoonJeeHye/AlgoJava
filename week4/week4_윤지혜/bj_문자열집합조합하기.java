package week4_윤지혜;

import java.io.*;
import java.util.*;

// 안됨
public class bj_문자열집합조합하기{

	static int k;
	static String s;
	
	static boolean visited[];
	static int cnt;
	static String arr[];
	
	static ArrayList<String> string1;
	static ArrayList<String> string2;
	static ArrayList<String> string3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		string1 = new ArrayList<>();
		string2 = new ArrayList<>();
		string3 = new ArrayList<>();
		
		arr = new String[3];
		
		for(int i = 0; i < 3; i++) {
			String line = br.readLine();
			arr[i] = line;
		}
		
		k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 3; i++) {
			visited = new boolean[arr[i].length()];
			Set("");
			cnt++;
		}
		
		
		
//		for(String s : string1) {
//			System.out.print(s+" ");
//		}
//		System.out.println();
//		for(String s : string2) {
//			System.out.print(s+" ");
//		}
//		System.out.println();
//		for(String s : string3) {
//			System.out.print(s+" ");
//		}
//		System.out.println();
	}

	private static void Set(String s) {

		if(s.length() == k) {
			if(cnt == 1) {
				string1.add(s);
				return;
			}
			else if(cnt == 2) {
				string2.add(s);
				return;
			}
			else {
				string3.add(s);
				return;
			}
		}
		
		
		Set(s+arr[cnt].charAt(i));
		
		
	}
}
