import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 행복유치원 {
	
	public static class dif implements Comparable{
		int dif;
		int index;
		dif(int dif,int index){
			this.dif=dif;
			this.index=index;
		}
		
		@Override
		public int compareTo(Object o) {
			return -Integer.compare(dif, ((dif)o).dif);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		int[] nk=Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n=nk[0];
		int k=nk[1];
		int[] students=Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		PriorityQueue<dif> q=new PriorityQueue<>();
		int[] tmp=new int[k-1];
		for(int i=0;i<n-1;i++) {
			q.add(new dif(students[i+1]-students[i],i));
		}
		for(int i=0;i<k-1;i++) {
			tmp[i]=q.remove().index;
		}
		if(k==1) {
			System.out.println(students[n-1]-students[0]);
			return;
		}
		Arrays.sort(tmp);
		//System.out.println(Arrays.toString(tmp));
		
		int sum=0;
		sum+=students[tmp[0]]-students[0];
		for(int i=1;i<k-1;i++) {
			sum+=students[tmp[i]]-students[tmp[i-1]+1];
		}
		sum+=students[n-1]-students[tmp[k-2]+1];
		System.out.println(sum);
	}

}
