import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 국회의원선거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bufferedReader.readLine());
		if(n==1) {
			System.out.println(0);
			return;
		}
		int a=Integer.parseInt(bufferedReader.readLine());	//후보 1번의 투표수
		PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());	//최대힙 우선순위큐 구현
		for(int i=0;i<n-1;i++) {
			pq.add(Integer.parseInt(bufferedReader.readLine()));
		}
		int tmp=0;
		int cnt=0;
		while(a<=(tmp=pq.poll())){	//후보1번의 득표수가 최대값이면 끝낸다.
			a++;
			pq.add(--tmp);
			cnt++;
		}
		System.out.println(cnt);
	}

}
