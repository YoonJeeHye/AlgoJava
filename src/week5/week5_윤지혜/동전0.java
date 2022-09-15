package week5.week5_윤지혜;
import java.util.*;

public class 동전0{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int Coin[] = new int[N];
		for(int n = 0; n < N; n++) {
			Coin[n] = sc.nextInt();
		}
		
		int answer = 0;
		for(int i = N-1; i >= 0; i--) {
			if(K >= Coin[i]) {
				answer += K/Coin[i];
				K = K % Coin[i];
			}
		}
		System.out.println(answer);
	}
}
