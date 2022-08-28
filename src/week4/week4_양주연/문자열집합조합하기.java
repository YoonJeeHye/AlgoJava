package week4.week4_양주연;

import java.io.*;
import java.util.*;

public class  문자열집합조합하기
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = new String[3];
		for(int i=0; i<3; i++) str[i] = br.readLine();
		int k = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		int[][] selected = new int[3][];
		for(int i=0; i<3; i++) selected[i] = new int[str[i].length()];
		for(int i=0; i<3; i++) Arrays.fill(selected[i], str[i].length()-k, str[i].length(), 1);
		for(int i=0; i<3; i++){
		    do{
    		    StringBuilder sb = new StringBuilder();
    		    for(int j=0; j<selected[i].length; j++){
    		        if(selected[i][j]==1){
    		            sb.append(str[i].charAt(j));
    		        }
    		    }
    		    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
    		}while(np(selected[i]));
		}
		ArrayList<String> answer = new ArrayList<>();
		for(Map.Entry<String, Integer> e : map.entrySet()){
		    if(e.getValue()>=2) answer.add(e.getKey());
		}
		if(answer.size()==0) bw.write("-1");
		else{
		    Collections.sort(answer);
		    for(String x : answer){
		        bw.write(x+"\n");
		    }
		}
		br.close();
		bw.flush();
		bw.close();
	}
	static boolean np(int[] numbers){
	    int N = numbers.length;
	    int i = N-1;
	    while(i>0 && numbers[i-1]>=numbers[i]) i--;
	    if(i==0) return false;
	    int j=N-1;
	    while(numbers[i-1]>=numbers[j]) j--;
	    swap(numbers, i-1, j);
	    int k=N-1;
	    while(i<k){
	        swap(numbers, i++, k--);
	    }
	    return true;
	} 
	static void swap(int[] numbers, int i, int j){
	    int tmp = numbers[i];
	    numbers[i] = numbers[j];
	    numbers[j] = tmp;
	}
}