package week4.week4_양주연;

import java.io.*;
import java.util.*;

public class 차이를최대로
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<N; i++){
		    arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);
		int max = Integer.MIN_VALUE;
		do{
		    int sum=0;
		    for(int i=0; i<N-1; i++){
		        sum+=Math.abs(arr[i]-arr[i+1]);
		    }
		    if(sum>max) max=sum;
		}while(np(arr));
		bw.write(max+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
	static boolean np(int[] numbers){
	    int N = numbers.length;
	    int i = N-1;
	    while(i>0 && numbers[i-1]>=numbers[i]) i--;
	    if(i==0) return false;
	    int j = N-1;
	    while(numbers[i-1]>=numbers[j]) j--;
	    swap(numbers, i-1, j);
	    int k = N-1;
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