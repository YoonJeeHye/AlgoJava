import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 후보추천하기 {
	
	static class Vote implements Comparable<Vote>{
		int stnum;
		int vtnum;
		int ornum;
		
		Vote(int stnum,int vtnum,int ornum){
			this.stnum=stnum;
			this.ornum=ornum;
			this.vtnum=vtnum;
		}
		
		@Override
		public int compareTo(Vote o) {
			if(this.vtnum==o.vtnum)return ornum-o.ornum;
			return vtnum-o.vtnum;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(stnum==((Vote)obj).stnum)
				return true;
			return false;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bufferedReader.readLine());
		int t=Integer.parseInt(bufferedReader.readLine());
		int[] arr=Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] student=new int[101];
		int[] order=new int[101];
		PriorityQueue<Vote> pq=new PriorityQueue<>();
		
		
		for(int i=0;i<arr.length;i++) {
			if(pq.size()==n && student[arr[i]]==0) {
				Vote tmp=pq.poll();
				student[tmp.stnum]=0;
				order[tmp.stnum]=0;
				pq.add(new Vote(arr[i],1,i));
				student[arr[i]]=1;
				order[arr[i]]=i;
			}
			else if(student[arr[i]]==0){
				student[arr[i]]++;
				order[arr[i]]=i;
				pq.add(new Vote(arr[i],1,i));
			}
			else {
				pq.remove(new Vote(arr[i],student[arr[i]],order[arr[i]]));
				student[arr[i]]++;
				pq.add(new Vote(arr[i],student[arr[i]],order[arr[i]]));
			}
			
//			for(Vote tmp1:pq) {
//				System.out.print(tmp1.stnum+" ");
//			}
//			System.out.println();
			
		}
		
		PriorityQueue<Integer> printtmp=new PriorityQueue<>();
		for(Vote tmp1:pq) {
			//System.out.println(tmp1.stnum);
			printtmp.add(tmp1.stnum);
		}
		
		for(int i=0;i<pq.size();i++) {
			System.out.print(printtmp.poll()+" ");
		}
		
	}

}
