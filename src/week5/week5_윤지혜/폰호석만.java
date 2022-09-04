package week5.week5_윤지혜;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// ...?
public class 폰호석만{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line[] = br.readLine().split(" ");
		
		String str1 = line[0];
		String str2 = line[1];
		
		int tempX = 0;
		int tempA = 0;
		int tempB = 0;
		int cnt = 0;
		
		for(int i = 2; i <= 36; i++) {
			for(int j = 2; j <= 36; j++) {
				if(i == j) continue;
				
				if(Integer.parseInt(str1, i) == Integer.parseInt(str2, j)) {
					tempX = Integer.parseInt(str1, i);
					tempA = i;
					tempB = j;
					cnt++;
				}
			}
		}
		
		if(cnt >= 2) System.out.println("Multiple");
		else if(cnt == 0) System.out.println("Impossible");
		
	}
}
